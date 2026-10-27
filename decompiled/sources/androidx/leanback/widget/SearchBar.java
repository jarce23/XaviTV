package androidx.leanback.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.os.Handler;
import android.speech.SpeechRecognizer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SearchBar extends RelativeLayout {
    public static final /* synthetic */ int L = 0;
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public SpeechRecognizer F;
    public boolean G;
    public SoundPool H;
    public final SparseIntArray I;
    public boolean J;
    public final Context K;

    /* renamed from: o, reason: collision with root package name */
    public SearchEditText f950o;

    /* renamed from: p, reason: collision with root package name */
    public SpeechOrbView f951p;

    /* renamed from: q, reason: collision with root package name */
    public ImageView f952q;

    /* renamed from: r, reason: collision with root package name */
    public String f953r;

    /* renamed from: s, reason: collision with root package name */
    public String f954s;

    /* renamed from: t, reason: collision with root package name */
    public String f955t;

    /* renamed from: u, reason: collision with root package name */
    public Drawable f956u;

    /* renamed from: v, reason: collision with root package name */
    public final Handler f957v;

    /* renamed from: w, reason: collision with root package name */
    public final InputMethodManager f958w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f959x;

    /* renamed from: y, reason: collision with root package name */
    public Drawable f960y;

    /* renamed from: z, reason: collision with root package name */
    public final int f961z;

    public SearchBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f957v = new Handler();
        this.f959x = false;
        this.I = new SparseIntArray();
        this.J = false;
        this.K = context;
        Resources resources = getResources();
        LayoutInflater.from(getContext()).inflate(R.layout.lb_search_bar, (ViewGroup) this, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.lb_search_bar_height));
        layoutParams.addRule(10, -1);
        setLayoutParams(layoutParams);
        setBackgroundColor(0);
        setClipChildren(false);
        this.f953r = _UrlKt.FRAGMENT_ENCODE_SET;
        this.f958w = (InputMethodManager) context.getSystemService("input_method");
        this.A = resources.getColor(R.color.lb_search_bar_text_speech_mode);
        this.f961z = resources.getColor(R.color.lb_search_bar_text);
        this.E = resources.getInteger(R.integer.lb_search_bar_speech_mode_background_alpha);
        this.D = resources.getInteger(R.integer.lb_search_bar_text_mode_background_alpha);
        this.C = resources.getColor(R.color.lb_search_bar_hint_speech_mode);
        this.B = resources.getColor(R.color.lb_search_bar_hint);
    }

    public final void a() {
        if (this.J) {
            return;
        }
        if (!hasFocus()) {
            requestFocus();
        }
        if (this.F == null) {
            return;
        }
        if (getContext().checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            throw new IllegalStateException("android.permission.RECORD_AUDIO required for search");
        }
        this.J = true;
        this.f950o.setText(_UrlKt.FRAGMENT_ENCODE_SET);
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
        this.F.setRecognitionListener(new h0(this));
        this.G = true;
        this.F.startListening(intent);
    }

    public final void b() {
        if (this.J) {
            this.f950o.setText(this.f953r);
            this.f950o.setHint(this.f954s);
            this.J = false;
            if (this.F == null) {
                return;
            }
            this.f951p.c();
            if (this.G) {
                this.F.cancel();
                this.G = false;
            }
            this.F.setRecognitionListener(null);
        }
    }

    public final void c() {
        String string = getResources().getString(R.string.lb_search_bar_hint);
        if (!TextUtils.isEmpty(this.f955t)) {
            string = this.f951p.isFocused() ? getResources().getString(R.string.lb_search_bar_hint_with_title_speech, this.f955t) : getResources().getString(R.string.lb_search_bar_hint_with_title, this.f955t);
        } else if (this.f951p.isFocused()) {
            string = getResources().getString(R.string.lb_search_bar_hint_speech);
        }
        this.f954s = string;
        SearchEditText searchEditText = this.f950o;
        if (searchEditText != null) {
            searchEditText.setHint(string);
        }
    }

    public final void d(boolean z10) {
        if (z10) {
            this.f960y.setAlpha(this.E);
            boolean isFocused = this.f951p.isFocused();
            int i10 = this.C;
            if (isFocused) {
                this.f950o.setTextColor(i10);
                this.f950o.setHintTextColor(i10);
            } else {
                this.f950o.setTextColor(this.A);
                this.f950o.setHintTextColor(i10);
            }
        } else {
            this.f960y.setAlpha(this.D);
            this.f950o.setTextColor(this.f961z);
            this.f950o.setHintTextColor(this.B);
        }
        c();
    }

    public Drawable getBadgeDrawable() {
        return this.f956u;
    }

    public CharSequence getHint() {
        return this.f954s;
    }

    public String getTitle() {
        return this.f955t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.H = new SoundPool(2, 1, 0);
        int[] iArr = {R.raw.lb_voice_failure, R.raw.lb_voice_open, R.raw.lb_voice_no_input, R.raw.lb_voice_success};
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = iArr[i10];
            this.I.put(i11, this.H.load(this.K, i11, 1));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        b();
        this.H.release();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f960y = ((RelativeLayout) findViewById(R.id.lb_search_bar_items)).getBackground();
        this.f950o = (SearchEditText) findViewById(R.id.lb_search_text_editor);
        ImageView imageView = (ImageView) findViewById(R.id.lb_search_bar_badge);
        this.f952q = imageView;
        Drawable drawable = this.f956u;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        this.f950o.setOnFocusChangeListener(new c0(this, 0));
        this.f950o.addTextChangedListener(new e0(this, new d0(this, 0)));
        this.f950o.setOnKeyboardDismissListener(new a6.n(5, this));
        this.f950o.setOnEditorActionListener(new f0(this));
        this.f950o.setPrivateImeOptions("escapeNorth,voiceDismiss");
        SpeechOrbView speechOrbView = (SpeechOrbView) findViewById(R.id.lb_search_bar_speech_orb);
        this.f951p = speechOrbView;
        speechOrbView.setOnOrbClickedListener(new g0(0, this));
        this.f951p.setOnFocusChangeListener(new c0(this, 1));
        d(hasFocus());
        c();
    }

    public void setBadgeDrawable(Drawable drawable) {
        this.f956u = drawable;
        ImageView imageView = this.f952q;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            if (drawable != null) {
                this.f952q.setVisibility(0);
            } else {
                this.f952q.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void setNextFocusDownId(int i10) {
        this.f951p.setNextFocusDownId(i10);
        this.f950o.setNextFocusDownId(i10);
    }

    public void setSearchAffordanceColors(m0 m0Var) {
        SpeechOrbView speechOrbView = this.f951p;
        if (speechOrbView != null) {
            speechOrbView.setNotListeningOrbColors(m0Var);
        }
    }

    public void setSearchAffordanceColorsInListening(m0 m0Var) {
        SpeechOrbView speechOrbView = this.f951p;
        if (speechOrbView != null) {
            speechOrbView.setListeningOrbColors(m0Var);
        }
    }

    public void setSearchQuery(String str) {
        b();
        this.f950o.setText(str);
        setSearchQueryInternal(str);
    }

    public void setSearchQueryInternal(String str) {
        if (TextUtils.equals(this.f953r, str)) {
            return;
        }
        this.f953r = str;
    }

    public void setSpeechRecognizer(SpeechRecognizer speechRecognizer) {
        b();
        SpeechRecognizer speechRecognizer2 = this.F;
        if (speechRecognizer2 != null) {
            speechRecognizer2.setRecognitionListener(null);
            if (this.G) {
                this.F.cancel();
                this.G = false;
            }
        }
        this.F = speechRecognizer;
    }

    public void setTitle(String str) {
        this.f955t = str;
        c();
    }

    public void setPermissionListener(j0 j0Var) {
    }

    public void setSearchBarListener(i0 i0Var) {
    }

    @Deprecated
    public void setSpeechRecognitionCallback(p0 p0Var) {
    }
}
