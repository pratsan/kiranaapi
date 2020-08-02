package com.pratsan.kirana.util;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class FirebaseInit {
    public void init() throws FileNotFoundException {
        FileInputStream serviceAccount =
                new FileInputStream("./kiranafinal-firebase-adminsdk-iiip8-2e03b7b2bc.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
               // .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://kiranafinal.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);

    }

}
