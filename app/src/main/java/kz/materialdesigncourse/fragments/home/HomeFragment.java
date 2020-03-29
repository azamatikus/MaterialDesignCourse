package kz.materialdesigncourse.fragments.home;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import kz.materialdesigncourse.R;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment {

    @BindView(R.id.userName)
    EditText user_name;

    @BindView(R.id.textInput)
    TextInputLayout textInputLayout;

    @BindView(R.id.button)
    Button btn_go;

    private static Unbinder unbinder;
    private SharedPreferences sPref;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        unbinder = ButterKnife.bind(this, root);

        btn_go.setOnClickListener(v -> {

            final String name = user_name.getText().toString().trim();

            if (!TextUtils.isEmpty(name)) {

                sPref = getActivity().getSharedPreferences("PREFERENCE", MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref.edit();
                ed.putString("user_name", name);
                ed.apply();

                Snackbar.make(root, "Flying to the Earth, " + name + "!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            } else {
                Snackbar.make(root, "Enter your name, please!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
