package com.example.lab07;


import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class FragmentTwo extends Fragment {
    private TextView textView;
    private SendMessage2 sendMessage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_two, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.tvTwo);
        Button btnPassData = view.findViewById(R.id.btTwo);
        EditText inData = view.findViewById(R.id.etTwo);
        btnPassData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage.sendData2(inData.getText().toString().trim());
            }
        });
    }
    interface SendMessage2 {
        void sendData2(String message);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        sendMessage = (SendMessage2) getActivity();

    }
    void displayReceivedData(String message) {
        textView.setText("Mensaje del Fragement 1: " + message);
    }
}