package androidx.leanback.widget;

import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.media3.ui.TrackSelectionView;
import app.shamel.tv.activities.CatchUpActivity;
import app.shamel.tv.activities.ChangePlaylistActivity;
import app.shamel.tv.activities.SearchActivity;
import app.shamel.tv.activities.SeasonActivity;
import app.shamel.tv.activities.mobile.LiveChannelMobileActivity;
import app.shamel.tv.activities.mobile.LiveMobileActivity;
import i1.a1;
import java.util.ArrayList;
import java.util.HashMap;
import m.u2;
import okhttp3.internal.url._UrlKt;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.R;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g0 implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1019o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f1020p;

    public /* synthetic */ g0(int i10, Object obj) {
        this.f1019o = i10;
        this.f1020p = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        int i10 = this.f1019o;
        Message message4 = null;
        message4 = null;
        boolean z10 = true;
        Object obj = this.f1020p;
        switch (i10) {
            case 0:
                SearchBar searchBar = (SearchBar) obj;
                if (!searchBar.J) {
                    searchBar.a();
                    break;
                } else {
                    searchBar.b();
                    break;
                }
            case 1:
                CatchUpActivity catchUpActivity = (CatchUpActivity) obj;
                int i11 = CatchUpActivity.f1576g0;
                Intent intent = new Intent();
                intent.putExtra("is_changed", _UrlKt.FRAGMENT_ENCODE_SET);
                catchUpActivity.setResult(-1, intent);
                catchUpActivity.finish();
                break;
            case 2:
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://shamel.tv/manage-playlists/login/"));
                    intent2.addFlags(872415232);
                    ((ChangePlaylistActivity) obj).startActivity(intent2);
                    break;
                } catch (Exception e7) {
                    Log.e("OpenURL", "Failed to open URL: https://shamel.tv/manage-playlists/login/", e7);
                    Toast.makeText(view.getContext(), "Unable to open link", 0).show();
                    return;
                }
            case 3:
                Intent intent3 = new Intent();
                intent3.putExtra("is_changed", _UrlKt.FRAGMENT_ENCODE_SET);
                SearchActivity searchActivity = (SearchActivity) obj;
                searchActivity.setResult(-1, intent3);
                searchActivity.finish();
                break;
            case 4:
                ((SeasonActivity) obj).finish();
                break;
            case 5:
                LiveChannelMobileActivity liveChannelMobileActivity = (LiveChannelMobileActivity) obj;
                if (!liveChannelMobileActivity.V0) {
                    liveChannelMobileActivity.V0 = true;
                    liveChannelMobileActivity.K();
                    break;
                } else if (liveChannelMobileActivity.f1937q0.getVisibility() == 8) {
                    liveChannelMobileActivity.f1937q0.setVisibility(0);
                    liveChannelMobileActivity.W0.removeCallbacks(liveChannelMobileActivity.f1932l0);
                    liveChannelMobileActivity.E();
                    break;
                }
                break;
            case 6:
                LiveMobileActivity liveMobileActivity = (LiveMobileActivity) obj;
                if (!liveMobileActivity.W0) {
                    liveMobileActivity.W0 = true;
                    liveMobileActivity.L();
                    break;
                } else if (liveMobileActivity.f1973r0.getVisibility() == 8) {
                    liveMobileActivity.f1973r0.setVisibility(0);
                    liveMobileActivity.X0.removeCallbacks(liveMobileActivity.f1970o0);
                    liveMobileActivity.F();
                    break;
                }
                break;
            case 7:
                com.google.android.material.datepicker.l lVar = (com.google.android.material.datepicker.l) obj;
                int i12 = lVar.f3761l0;
                if (i12 != 2) {
                    if (i12 == 1) {
                        lVar.K(2);
                        lVar.f3763n0.announceForAccessibility(lVar.l().getString(R.string.mtrl_picker_toggled_to_year_selection));
                        break;
                    }
                } else {
                    lVar.K(1);
                    lVar.f3764o0.announceForAccessibility(lVar.l().getString(R.string.mtrl_picker_toggled_to_day_selection));
                    break;
                }
                break;
            case 8:
                f.e eVar = (f.e) obj;
                if (view == eVar.f4756i && (message3 = eVar.f4758k) != null) {
                    message4 = Message.obtain(message3);
                } else if (view == eVar.f4759l && (message2 = eVar.f4761n) != null) {
                    message4 = Message.obtain(message2);
                } else if (view == eVar.f4762o && (message = eVar.f4764q) != null) {
                    message4 = Message.obtain(message);
                }
                if (message4 != null) {
                    message4.sendToTarget();
                }
                eVar.E.obtainMessage(1, eVar.f4750b).sendToTarget();
                break;
            case 9:
                ((h5.n) obj).J(false, false);
                break;
            case 10:
                ((h5.x) obj).J(false, false);
                break;
            case 11:
                h5.h0 h0Var = (h5.h0) obj;
                if (!h0Var.f5606y0.getText().toString().isEmpty()) {
                    if (!h0Var.A0.equalsIgnoreCase(h0Var.f5606y0.getText().toString())) {
                        h0Var.f5607z0.u();
                        h0Var.f5606y0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
                        break;
                    } else {
                        h0Var.J(false, false);
                        h0Var.f5607z0.y();
                        break;
                    }
                } else {
                    h0Var.f5607z0.t();
                    break;
                }
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                ((h5.i0) obj).J(false, false);
                break;
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                h5.k0 k0Var = (h5.k0) obj;
                k0Var.J(false, false);
                k0Var.f5619z0.f();
                break;
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                ((h5.r0) obj).J(false, false);
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((k.a) obj).a();
                break;
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                u2 u2Var = ((Toolbar) obj).f470c0;
                l.n nVar = u2Var != null ? u2Var.f8574p : null;
                if (nVar != null) {
                    nVar.collapseActionView();
                    break;
                }
                break;
            default:
                TrackSelectionView trackSelectionView = (TrackSelectionView) obj;
                HashMap hashMap = trackSelectionView.f1232u;
                if (view == trackSelectionView.f1228q) {
                    trackSelectionView.f1237z = true;
                    hashMap.clear();
                } else if (view == trackSelectionView.f1229r) {
                    trackSelectionView.f1237z = false;
                    hashMap.clear();
                } else {
                    trackSelectionView.f1237z = false;
                    Object tag = view.getTag();
                    tag.getClass();
                    u3.i0 i0Var = (u3.i0) tag;
                    a1 a1Var = i0Var.f12410a;
                    i1.u0 u0Var = a1Var.f5799b;
                    int i13 = i0Var.f12411b;
                    i1.v0 v0Var = (i1.v0) hashMap.get(u0Var);
                    if (v0Var == null) {
                        if (!trackSelectionView.f1234w && !hashMap.isEmpty()) {
                            hashMap.clear();
                        }
                        hashMap.put(u0Var, new i1.v0(u0Var, o9.g0.r(Integer.valueOf(i13))));
                    } else {
                        ArrayList arrayList = new ArrayList(v0Var.f6052b);
                        boolean isChecked = ((CheckedTextView) view).isChecked();
                        Object[] objArr = trackSelectionView.f1233v && a1Var.f5800c;
                        if (objArr == false && (!trackSelectionView.f1234w || trackSelectionView.f1231t.size() <= 1)) {
                            z10 = false;
                        }
                        if (isChecked && z10) {
                            arrayList.remove(Integer.valueOf(i13));
                            if (arrayList.isEmpty()) {
                                hashMap.remove(u0Var);
                            } else {
                                hashMap.put(u0Var, new i1.v0(u0Var, arrayList));
                            }
                        } else if (!isChecked) {
                            if (objArr == true) {
                                arrayList.add(Integer.valueOf(i13));
                                hashMap.put(u0Var, new i1.v0(u0Var, arrayList));
                            } else {
                                hashMap.put(u0Var, new i1.v0(u0Var, o9.g0.r(Integer.valueOf(i13))));
                            }
                        }
                    }
                }
                trackSelectionView.b();
                break;
        }
    }
}
