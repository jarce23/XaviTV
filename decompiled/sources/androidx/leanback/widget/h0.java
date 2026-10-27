package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.regex.Matcher;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h0 implements RecognitionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchBar f1021a;

    public h0(SearchBar searchBar) {
        this.f1021a = searchBar;
    }

    @Override // android.speech.RecognitionListener
    public final void onError(int i10) {
        switch (i10) {
            case 1:
                int i11 = SearchBar.L;
                Log.w("SearchBar", "recognizer network timeout");
                break;
            case 2:
                int i12 = SearchBar.L;
                Log.w("SearchBar", "recognizer network error");
                break;
            case 3:
                int i13 = SearchBar.L;
                Log.w("SearchBar", "recognizer audio error");
                break;
            case 4:
                int i14 = SearchBar.L;
                Log.w("SearchBar", "recognizer server error");
                break;
            case 5:
                int i15 = SearchBar.L;
                Log.w("SearchBar", "recognizer client error");
                break;
            case 6:
                int i16 = SearchBar.L;
                Log.w("SearchBar", "recognizer speech timeout");
                break;
            case 7:
                int i17 = SearchBar.L;
                Log.w("SearchBar", "recognizer no match");
                break;
            case 8:
                int i18 = SearchBar.L;
                Log.w("SearchBar", "recognizer busy");
                break;
            case 9:
                int i19 = SearchBar.L;
                Log.w("SearchBar", "recognizer insufficient permissions");
                break;
            default:
                int i20 = SearchBar.L;
                Log.d("SearchBar", "recognizer other error");
                break;
        }
        SearchBar searchBar = this.f1021a;
        searchBar.b();
        searchBar.f957v.post(new androidx.emoji2.text.j(R.raw.lb_voice_failure, 1, searchBar));
    }

    @Override // android.speech.RecognitionListener
    public final void onPartialResults(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
        if (stringArrayList == null || stringArrayList.size() == 0) {
            return;
        }
        String str = stringArrayList.get(0);
        String str2 = stringArrayList.size() > 1 ? stringArrayList.get(1) : null;
        SearchEditText searchEditText = this.f1021a.f950o;
        searchEditText.getClass();
        if (str == null) {
            str = _UrlKt.FRAGMENT_ENCODE_SET;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (str2 != null) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str2);
            Matcher matcher = t0.f1079t.matcher(str2);
            while (matcher.find()) {
                int start = matcher.start() + length;
                spannableStringBuilder.setSpan(new s0(searchEditText, str2.charAt(matcher.start()), start), start, matcher.end() + length, 33);
            }
        }
        searchEditText.f1084r = Math.max(str.length(), searchEditText.f1084r);
        searchEditText.setText(new SpannedString(spannableStringBuilder));
        searchEditText.bringPointIntoView(searchEditText.length());
        ObjectAnimator objectAnimator = searchEditText.f1085s;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        int streamPosition = searchEditText.getStreamPosition();
        int length2 = searchEditText.length();
        int i10 = length2 - streamPosition;
        if (i10 > 0) {
            if (searchEditText.f1085s == null) {
                ObjectAnimator objectAnimator2 = new ObjectAnimator();
                searchEditText.f1085s = objectAnimator2;
                objectAnimator2.setTarget(searchEditText);
                searchEditText.f1085s.setProperty(t0.f1080u);
            }
            searchEditText.f1085s.setIntValues(streamPosition, length2);
            searchEditText.f1085s.setDuration(i10 * 50);
            searchEditText.f1085s.start();
        }
    }

    @Override // android.speech.RecognitionListener
    public final void onReadyForSpeech(Bundle bundle) {
        SearchBar searchBar = this.f1021a;
        SpeechOrbView speechOrbView = searchBar.f951p;
        speechOrbView.setOrbColors(speechOrbView.H);
        speechOrbView.setOrbIcon(speechOrbView.getResources().getDrawable(R.drawable.lb_ic_search_mic));
        speechOrbView.a(true);
        speechOrbView.A = false;
        speechOrbView.b();
        View view = speechOrbView.f965q;
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        speechOrbView.J = 0;
        speechOrbView.K = true;
        searchBar.f957v.post(new androidx.emoji2.text.j(R.raw.lb_voice_open, 1, searchBar));
    }

    @Override // android.speech.RecognitionListener
    public final void onResults(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
        SearchBar searchBar = this.f1021a;
        if (stringArrayList != null) {
            String str = stringArrayList.get(0);
            searchBar.f953r = str;
            searchBar.f950o.setText(str);
            TextUtils.isEmpty(searchBar.f953r);
        }
        searchBar.b();
        searchBar.f957v.post(new androidx.emoji2.text.j(R.raw.lb_voice_success, 1, searchBar));
    }

    @Override // android.speech.RecognitionListener
    public final void onRmsChanged(float f10) {
        this.f1021a.f951p.setSoundLevel(f10 < 0.0f ? 0 : (int) (f10 * 10.0f));
    }

    @Override // android.speech.RecognitionListener
    public final void onBeginningOfSpeech() {
    }

    @Override // android.speech.RecognitionListener
    public final void onEndOfSpeech() {
    }

    @Override // android.speech.RecognitionListener
    public final void onBufferReceived(byte[] bArr) {
    }

    @Override // android.speech.RecognitionListener
    public final void onEvent(int i10, Bundle bundle) {
    }
}
