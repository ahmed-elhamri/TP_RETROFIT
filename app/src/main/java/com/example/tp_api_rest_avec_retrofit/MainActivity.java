    package com.example.tp_api_rest_avec_retrofit;

    import android.os.Bundle;
    import android.text.Editable;
    import android.text.TextWatcher;
    import android.view.View;
    import android.widget.EditText;
    import android.widget.ProgressBar;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.lifecycle.ViewModelProvider;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import com.example.tp_api_rest_avec_retrofit.adapter.UserAdapter;
    import com.example.tp_api_rest_avec_retrofit.model.User;
    import com.example.tp_api_rest_avec_retrofit.viewmodel.UserViewModel;

    import java.util.List;

    public class MainActivity extends AppCompatActivity {

        private UserViewModel userViewModel;
        private UserAdapter userAdapter;
        private RecyclerView recyclerView;
        private ProgressBar progressBar;
        private EditText searchEditText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Initialiser les vues
            recyclerView = findViewById(R.id.recyclerView);
            progressBar = findViewById(R.id.progressBar);

            // Configurer le RecyclerView
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            userAdapter = new UserAdapter();
            recyclerView.setAdapter(userAdapter);

            // Afficher le ProgressBar pendant le chargement
            progressBar.setVisibility(View.VISIBLE);

            // Initialiser le ViewModel
            userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

            // Observer les données
            userViewModel.getUsers().observe(this, users -> {
                progressBar.setVisibility(View.GONE);
                if (users != null) {
                    userAdapter.setUserList(users);
                } else {
                    Toast.makeText(MainActivity.this, "Erreur lors du chargement des données", Toast.LENGTH_SHORT).show();
                }
            });

            searchEditText = findViewById(R.id.searchEditText);

            searchEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    userAdapter.filter(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {}
            });
        }
    }