package com.example.mendez26.recycler1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String [] nombres={"ARANDA PATRON NOMAR JAZIEL\n13400381\nIngenieria en sistemas computacionales",
            "CARDENAS RAMOS FRANCISCO EMANUEL\n13400382\nIngenieria en sistemas computacionales",
            "CASTILLO CORRALES VICTOR EMMANUEL\n13400383\nIngenieria en sistemas computacionales",
            "CERVANTES JIMÉNEZ JOSÉ MIGUEL\n13400384\nIngenieria en sistemas computacionales",
            "CORDERO RIVERA SELVA YAZMIN\n13400385\nIngenieria en sistemas computacionales",
            "CORDERO VILLA OSCAR ALBERTO\n13400386\nIngenieria en sistemas computacionales",
            "ESPINOSA ABANDO DENISSE YANETH\n13400387\nIngenieria en sistemas computacionales",
            "FIGUEROA CUETO JUAN RAMON\n13400388\nIngenieria en sistemas computacionales",
            "GALLEGOS GODINEZ FRANCISCO JAVIER\n13400401\nIngenieria en sistemas computacionales",
            "GIL LLANOS JUAN PEDRO\n13400402\nIngenieria en sistemas computacionales",
            "GONZALEZ ARELLANO ERNESTO\n13400403\nIngenieria en sistemas computacionales",
            "GUTIERREZ ESPARZA BRAYAN JESUS\n13400404\nIngenieria en sistemas computacionales",
            "GUTIÉRREZ ROJAS BRYAN\n13400405\nIngenieria en sistemas computacionales",
            "LOPEZ ALVARADO MISSAEL\n13400406\nIngenieria en sistemas computacionales",
            "MARTINEZ BAÑUELOS ERIKA LIZBETH\n13400407\nIngenieria en sistemas computacionales",
            "MENDEZ SANTANA KEVIN ALEJANDRO\n13400408\nIngenieria en sistemas computacionales",
            "MONROY SALCEDO JOSE DE JESUS\n13400409\nIngenieria en sistemas computacionales",
            "PADILLA SIMÓN BRIAN EFRÉN\n13400310\nIngenieria en sistemas computacionales",
            "PARRA DOMINGUEZ DYLAN SALVADOR\n13400311\nIngenieria en sistemas computacionales",
            "PEREZ ARAIZA FLOR MARIELA\n13400312\nIngenieria en sistemas computacionales",
            "PUGA FLORES CARLOS\n13400313\nIngenieria en sistemas computacionales",
            "REYES GODINEZ CARLA GUADALUPE\n13400314\nIngenieria en sistemas computacionales",
            "REYES GUERRERO GUILLERMO GUADALUPE\n134003815\nIngenieria en sistemas computacionales",
            "RICO ESPARZA HENRY\n13400316\nIngenieria en sistemas computacionales",
            "RIVERA RAMIREZ DAVID\n13400317\nIngenieria en sistemas computacionales",
            "SANCHEZ CARRILLO BETSY DEL CARMEN\n13400318\nIngenieria en sistemas computacionales",
            "SILVA CAMACHO EDUARDO LUIS\n13400319\nIngenieria en sistemas computacionales",
            "TORRES CUETO JESUS MANUEL\n134003820\nIngenieria en sistemas computacionales",
            "VALDEZ LOPEZ HOLLIVER EDUARDO\n13400321\nIngenieria en sistemas computacionales",
            "VALENZUELA MIRAMONTES JOSE PABLO\n13400322\nIngenieria en sistemas computacionales",
            "ZAMORANO ALCALÁ GUILLERMO\n13400323\nIngenieria en sistemas computacionales"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear referencias hacia el componente RecycleriView
        recyclerView = findViewById(R.id.recycler_id);

        // Crear un objeto de tipo RecyclerAdapter que recibe un arreglo de cadenas
        adapter = new RecyclerAdapter(nombres);

        // Crea un objeto de tipo LinearLayoutManager
        layoutManager = new LinearLayoutManager(this);

        // Establecer el LayautManager
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // Establecer el Adapter
        recyclerView.setAdapter(adapter);

    }//onCreate

}//class
