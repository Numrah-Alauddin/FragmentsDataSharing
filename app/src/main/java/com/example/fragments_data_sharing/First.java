package com.example.fragments_data_sharing;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class First extends Fragment {

    Button btn;
    Button btn2;
    EditText name_et;


    public First() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_first, container, false);

        btn = view.findViewById(R.id.show_activity);
        btn2 = view.findViewById(R.id.show_fragment);
        name_et = view.findViewById(R.id.name);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getContext(),"ABc",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getContext(),"ABc",Toast.LENGTH_SHORT).show();

                replaceFragment();
            }
        });

        return view;

    }

    private void replaceFragment() {

        String name=name_et.getText().toString();
        Bundle bundle=new Bundle();
        bundle.putString("data",name);

        Second fragment=new Second();
        fragment.setArguments(bundle);


        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.fragments_container,fragment);
        transaction.commit();
    }

}
