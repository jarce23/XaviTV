package app.shamel.tv.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import app.shamel.tv.models.MovieCreditModel;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.LiveHorizontalGridView;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import java.util.ArrayList;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MovieCreditActivity extends f.j implements View.OnClickListener {
    public d5.e M;
    public ImageButton N;
    public Button O;
    public Button P;
    public MovieCreditModel Q;
    public ImageView R;
    public ImageView S;
    public int T;
    public SimpleRatingBar U;
    public LiveHorizontalGridView V;
    public TextView W;
    public TextView X;
    public TextView Y;
    public TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    public final ArrayList f1732a0 = new ArrayList();

    /* renamed from: b0, reason: collision with root package name */
    public WordModels f1733b0 = new WordModels();

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 19) {
                if (keyCode == 20 && this.N.hasFocus()) {
                    this.N.setFocusable(false);
                    this.O.requestFocus();
                    return true;
                }
            } else if (this.O.hasFocus() || this.P.hasFocus()) {
                this.N.setFocusable(true);
                this.N.requestFocus();
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_back) {
            finish();
            return;
        }
        if (id == R.id.btn_play) {
            if (this.Q != null) {
                Intent intent = new Intent(this, (Class<?>) SearchActivity.class);
                intent.putExtra("search_key", this.Q.getTitle());
                startActivity(intent);
                return;
            }
            return;
        }
        if (id != R.id.btn_trailer) {
            return;
        }
        j5.f.a(e5.l.f4612h).getTmdbVideoModels(this.Q.getId() + "/videos?api_key=d96abf17668601f56b3d7b8336a61933").enqueue(new h0(this, 1));
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_movie_creadit);
        k5.j.a(this);
        this.f1733b0 = app.shamel.tv.helper.a.k(this);
        this.R = (ImageView) findViewById(R.id.movie_bg);
        this.S = (ImageView) findViewById(R.id.image_logo);
        this.N = (ImageButton) findViewById(R.id.btn_back);
        this.V = (LiveHorizontalGridView) findViewById(R.id.recycler_vod);
        this.X = (TextView) findViewById(R.id.txt_name);
        this.Z = (TextView) findViewById(R.id.txt_year);
        this.Y = (TextView) findViewById(R.id.txt_rating);
        this.W = (TextView) findViewById(R.id.txt_description);
        this.U = (SimpleRatingBar) findViewById(R.id.rating_bar);
        this.O = (Button) findViewById(R.id.btn_play);
        this.P = (Button) findViewById(R.id.btn_trailer);
        this.N.setOnClickListener(this);
        this.O.setOnClickListener(this);
        this.P.setOnClickListener(this);
        ArrayList arrayList = new ArrayList();
        int i10 = 2;
        d5.e eVar = new d5.e(i10);
        eVar.f4086e = -1;
        eVar.f4087f = this;
        eVar.f4088h = arrayList;
        this.M = eVar;
        eVar.g = new h0(this, i10);
        this.V.setAdapter(eVar);
        int i11 = 0;
        if (app.shamel.tv.helper.a.l(this)) {
            this.V.setLoop(false);
            this.V.setPreserveFocusAfterLayout(true);
            this.V.setOnChildViewHolderSelectedListener(new e(11, new View[]{null}));
        } else {
            this.V.setLayoutManager(new LinearLayoutManager(0));
            this.V.setHasFixedSize(true);
        }
        this.O.setText(this.f1733b0.getFind_movie());
        this.P.setText(this.f1733b0.getWatch_trailer());
        this.T = getIntent().getIntExtra("person_id", 0);
        getIntent().getStringExtra("name");
        if (this.T > 0) {
            j5.f.a(e5.l.f4613i).getMovieCreditModels(this.T + "/movie_credits?api_key=d96abf17668601f56b3d7b8336a61933&language=en-US").enqueue(new h0(this, i11));
        }
        this.N.setFocusable(false);
        this.O.requestFocus();
    }

    public final void u(MovieCreditModel movieCreditModel) {
        this.Q = movieCreditModel;
        this.X.setText(movieCreditModel.getTitle());
        this.W.setText(movieCreditModel.getOverview());
        this.Z.setText(movieCreditModel.getRelease_date());
        try {
            this.Y.setText(_UrlKt.FRAGMENT_ENCODE_SET + (movieCreditModel.getVote_average() / 2.0f));
            this.U.setRating(movieCreditModel.getVote_average() / 2.0f);
        } catch (Exception unused) {
            this.Y.setText("N/A");
            this.U.setRating(0.0f);
        }
        if (movieCreditModel.getBackdrop_path() == null || movieCreditModel.getBackdrop_path().isEmpty()) {
            com.bumptech.glide.b.e(getApplicationContext()).q(Integer.valueOf(R.drawable.background1)).E(this.R);
        } else {
            com.bumptech.glide.b.e(getApplicationContext()).r(e5.l.f4614j + movieCreditModel.getBackdrop_path()).E(this.R);
        }
        if (movieCreditModel.getPoster_path() == null || movieCreditModel.getPoster_path().isEmpty()) {
            com.bumptech.glide.b.e(getApplicationContext()).q(Integer.valueOf(R.drawable.default_bg)).E(this.S);
            return;
        }
        com.bumptech.glide.b.e(getApplicationContext()).r(e5.l.f4614j + movieCreditModel.getPoster_path()).E(this.S);
    }
}
