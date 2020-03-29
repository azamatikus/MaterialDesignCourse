package kz.materialdesigncourse.fragments.moon;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import kz.materialdesigncourse.R;

import static android.content.Context.MODE_PRIVATE;

public class MoonFragment extends Fragment {

    @BindView(R.id.button)
    Button btn_go;

    private static Unbinder unbinder;
    private String name;
    private SharedPreferences sPref;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_moon, container, false);

        unbinder = ButterKnife.bind(this, root);

        sPref = getActivity().getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        name = sPref.getString("user_name", "captain");

        btn_go.setOnClickListener(v -> {

            Snackbar.make(root, "Flying to the Moon, " + name + "!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        });

        return root;
    }

    public void onMoonClicked(View view) {
        Snackbar.make(view, "Taking off, Yay!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
