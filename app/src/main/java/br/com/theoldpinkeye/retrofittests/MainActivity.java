package br.com.theoldpinkeye.retrofittests;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

  private List<Repo> repositories;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    repositories = new ArrayList<>();

    // Domínio base da API
    String API_BASE_URL = "https://api.github.com/";

    // Criar esse HttpClient que vai permitir a construção da request
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    // Crio uma instância da classe Retrofit que irá converter os dados recebidos
    Retrofit.Builder builder =
        new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create() // usando o Gson para gerar um objeto List<Repo>
            );

    Retrofit retrofit =
        builder
            .client(
                httpClient.build()
            )
            .build();

    // Cria um adapter REST baseado na interface criada que mostra o Endpoint da API
    GitHubService client = retrofit.create(GitHubService.class);

    // Fazendo a Call para obter a lista de repositórios
    Call<List<Repo>> call =
        client.listRepos("DanteSouzaeSouza");

    // Executando a chamada de forma assíncrona, tratando os resultados
    call.enqueue(new Callback<List<Repo>>() {
      @Override
      public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
        // Se a chamada deu resultado positivo:
        // TODO: Usar a lista de repositórios e exibi-la
        Log.i("Response:", response.toString());

        repositories = response.body();

        if (repositories != null) {
          for (Repo r : repositories) {
            Log.d("Repo", r.toString());
          }
        }


      }

      @Override
      public void onFailure(Call<List<Repo>> call, Throwable t) {
        // Se a chamada falhar:
        // TODO:  tratar o erro
        Log.e("ERRO", t.toString());
      }
    });


  }
}