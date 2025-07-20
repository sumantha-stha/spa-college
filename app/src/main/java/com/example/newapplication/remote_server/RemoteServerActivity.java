package com.example.newapplication.remote_server;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.newapplication.R;
import com.example.newapplication.remote_server.entity.PostRequest;
import com.example.newapplication.remote_server.entity.PostResponse;
import com.example.newapplication.remote_server.helper_class.ApiHelper;
import com.example.newapplication.remote_server.helper_class.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RemoteServerActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextBody;
    private Button buttonSubmit;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_remote_server);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextBody = findViewById(R.id.editTextBody);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        retrofit = ApiHelper.getInstance();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTextTitle.getText().toString();
                String body = editTextBody.getText().toString();

                if (title.isEmpty()) {
                    editTextTitle.setError("Enter title");
                } else if (body.isEmpty()) {
                    editTextBody.setError("Enter body");
                } else {
                    callRemoteServer(title, body);
                }
            }
        });

    }

    private void callRemoteServer(String title, String body) {
        PostRequest postRequest = new PostRequest();
        postRequest.setTitle(title);
        postRequest.setBody(body);
        postRequest.setUserId(1);

        ApiService apiService = retrofit.create(ApiService.class);

        Call<PostResponse> call = apiService.submitBody(postRequest);
        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if (response.code() == 201){
                    PostResponse postResponse = response.body();

                    Log.i("TAG", "onResponse: title = "+postResponse.getTitle());
                    Log.i("TAG", "onResponse: body = "+postResponse.getBody());
                } else{
                    Toast.makeText(RemoteServerActivity.this, "Error in API call "+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                Toast.makeText(RemoteServerActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}