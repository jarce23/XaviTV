package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends androidx.activity.result.g {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ f.j f300h;

    public i(f.j jVar) {
        this.f300h = jVar;
    }

    @Override // androidx.activity.result.g
    public final void b(int i10, com.bumptech.glide.f fVar, Object obj) {
        Bundle bundle;
        int i11;
        f.j jVar = this.f300h;
        d.a k10 = fVar.k(jVar, obj);
        if (k10 != null) {
            new Handler(Looper.getMainLooper()).post(new h(this, i10, k10, 0));
            return;
        }
        Intent f10 = fVar.f(jVar, obj);
        if (f10.getExtras() != null && f10.getExtras().getClassLoader() == null) {
            f10.setExtrasClassLoader(jVar.getClassLoader());
        }
        if (f10.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundle = f10.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            f10.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(f10.getAction())) {
            String[] stringArrayExtra = f10.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            HashSet hashSet = new HashSet();
            for (int i12 = 0; i12 < stringArrayExtra.length; i12++) {
                if (TextUtils.isEmpty(stringArrayExtra[i12])) {
                    throw new IllegalArgumentException(android.support.v4.media.d.r(new StringBuilder("Permission request for permissions "), Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
                }
                if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(stringArrayExtra[i12], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i12));
                }
            }
            int size = hashSet.size();
            String[] strArr = size > 0 ? new String[stringArrayExtra.length - size] : stringArrayExtra;
            if (size > 0) {
                if (size == stringArrayExtra.length) {
                    return;
                }
                int i13 = 0;
                for (int i14 = 0; i14 < stringArrayExtra.length; i14++) {
                    if (!hashSet.contains(Integer.valueOf(i14))) {
                        strArr[i13] = stringArrayExtra[i14];
                        i13++;
                    }
                }
            }
            jVar.requestPermissions(stringArrayExtra, i10);
            return;
        }
        if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(f10.getAction())) {
            jVar.startActivityForResult(f10, i10, bundle2);
            return;
        }
        androidx.activity.result.h hVar = (androidx.activity.result.h) f10.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            i11 = i10;
            try {
                jVar.startIntentSenderForResult(hVar.f347o, i11, hVar.f348p, hVar.f349q, hVar.f350r, 0, bundle2);
            } catch (IntentSender.SendIntentException e7) {
                e = e7;
                new Handler(Looper.getMainLooper()).post(new h(this, i11, e, 1));
            }
        } catch (IntentSender.SendIntentException e8) {
            e = e8;
            i11 = i10;
        }
    }
}
