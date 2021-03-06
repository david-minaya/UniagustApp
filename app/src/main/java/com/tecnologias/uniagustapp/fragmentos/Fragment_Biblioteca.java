package com.tecnologias.uniagustapp.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.tecnologias.uniagustapp.R;
import com.tecnologias.uniagustapp.utils.Connectivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Biblioteca extends Fragment {


    public Fragment_Biblioteca() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_biblioteca, container, false);

        String url="http://uniagustiniana.edu.co/biblioteca-uniagustiniana";
        WebView view=(WebView) v.findViewById(R.id.wv_biblioteca);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new WebViewClient());// Agregamos un WebViewCliente, esto permite que se sigan ejecutando los links dentro de este WebView
        if (Connectivity.isOnline(getActivity())) {
            view.loadUrl(url);
            Toast.makeText(getActivity(),"SI hay conexión!",Toast.LENGTH_SHORT).show();
        } else {
            //view.loadUrl("file:///android_asset/html/pagina_error.html");
            Toast.makeText(getActivity(),"NO hay conexión!",Toast.LENGTH_SHORT).show();
        }

        return v;
    }

    public interface OnFragmentInteractionListener {
    }
}
