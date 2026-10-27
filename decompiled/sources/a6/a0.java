package a6;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import app.shamel.tv.activities.AddGroupActivity;
import app.shamel.tv.activities.SearchActivity;
import app.shamel.tv.activities.SettingActivity;
import c2.b1;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class a0 implements m6.g, a7.j, app.shamel.tv.helper.s, n9.d, l1.h, ObjectConstructor, y2.g, io.realm.t, g9.b0 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f35o;

    public /* synthetic */ a0(int i10) {
        this.f35o = i10;
    }

    @Override // y2.g
    public boolean a(int i10, int i11, int i12, int i13, int i14) {
        if (i11 == 67 && i12 == 79 && i13 == 77 && (i14 == 77 || i10 == 2)) {
            return true;
        }
        if (i11 == 77 && i12 == 76 && i13 == 76) {
            return i14 == 84 || i10 == 2;
        }
        return false;
    }

    @Override // l1.h
    public void accept(Object obj) {
        switch (this.f35o) {
            case 8:
                ((b1) obj).f2528b.getClass();
                break;
            default:
                ((ExecutorService) obj).shutdown();
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0326  */
    /* JADX WARN: Type inference failed for: r2v36, types: [android.text.Spannable, android.text.SpannableString] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    @Override // a7.j, n9.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object apply(java.lang.Object r36) {
        /*
            Method dump skipped, instructions count: 1042
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.a0.apply(java.lang.Object):java.lang.Object");
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        Map lambda$newMapConstructor$14;
        Map lambda$newMapConstructor$15;
        Map lambda$newMapConstructor$16;
        Map lambda$newMapConstructor$17;
        Map lambda$newMapConstructor$18;
        Collection lambda$newCollectionConstructor$10;
        Collection lambda$newCollectionConstructor$11;
        Collection lambda$newCollectionConstructor$12;
        Collection lambda$newCollectionConstructor$13;
        switch (this.f35o) {
            case 10:
                lambda$newMapConstructor$14 = ConstructorConstructor.lambda$newMapConstructor$14();
                return lambda$newMapConstructor$14;
            case 11:
                lambda$newMapConstructor$15 = ConstructorConstructor.lambda$newMapConstructor$15();
                return lambda$newMapConstructor$15;
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                lambda$newMapConstructor$16 = ConstructorConstructor.lambda$newMapConstructor$16();
                return lambda$newMapConstructor$16;
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                lambda$newMapConstructor$17 = ConstructorConstructor.lambda$newMapConstructor$17();
                return lambda$newMapConstructor$17;
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                lambda$newMapConstructor$18 = ConstructorConstructor.lambda$newMapConstructor$18();
                return lambda$newMapConstructor$18;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                lambda$newCollectionConstructor$10 = ConstructorConstructor.lambda$newCollectionConstructor$10();
                return lambda$newCollectionConstructor$10;
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                lambda$newCollectionConstructor$11 = ConstructorConstructor.lambda$newCollectionConstructor$11();
                return lambda$newCollectionConstructor$11;
            case 17:
                lambda$newCollectionConstructor$12 = ConstructorConstructor.lambda$newCollectionConstructor$12();
                return lambda$newCollectionConstructor$12;
            default:
                lambda$newCollectionConstructor$13 = ConstructorConstructor.lambda$newCollectionConstructor$13();
                return lambda$newCollectionConstructor$13;
        }
    }

    @Override // io.realm.t
    public void e(io.realm.u uVar) {
        switch (this.f35o) {
            case 23:
                uVar.n();
                break;
            case 24:
                uVar.n();
                break;
            default:
                uVar.n();
                break;
        }
    }

    @Override // m6.g
    public Object get() {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT == 34) {
            Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
            config = Bitmap.Config.HARDWARE;
            Bitmap copy = createBitmap.copy(config, false);
            createBitmap.recycle();
            r2 = copy == null;
            if (Log.isLoggable("GainmapWorkaroundCalc", 2)) {
                Log.v("GainmapWorkaroundCalc", "calculateNeedsGainmapDecodeWorkaround=" + r2);
            }
            if (copy != null) {
                copy.recycle();
            }
        }
        return Boolean.valueOf(r2);
    }

    @Override // app.shamel.tv.helper.s
    public void j() {
        switch (this.f35o) {
            case 2:
                int i10 = AddGroupActivity.f1570f0;
                break;
            case 3:
                int i11 = SearchActivity.f1784d0;
                break;
            default:
                int i12 = SettingActivity.f1845u0;
                break;
        }
    }
}
