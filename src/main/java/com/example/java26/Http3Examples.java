package com.example.java26;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Demonstrates HTTP/3 usage with the Java standard HTTP client.
 */
public final class Http3Examples {

    private Http3Examples() {
    }

    public static HttpClient newHttp3Client() {
        return HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(3))
                .version(HttpClient.Version.HTTP_3)
                .build();
    }

    public static String fetchBody(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(5))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response =
                newHttp3Client().send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
