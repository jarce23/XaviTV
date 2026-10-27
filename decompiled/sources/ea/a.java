package ea;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseBooleanArray;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import i1.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import k0.f;
import k0.g;
import l1.d;
import okhttp3.internal.url._UrlKt;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import t5.y;
import w3.i;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements io.realm.internal.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4679a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4680b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f4681c;

    public a(int i10) {
        this.f4679a = i10;
        switch (i10) {
            case 1:
                this.f4681c = new SparseBooleanArray();
                break;
            case 4:
                this.f4681c = new Handler(Looper.getMainLooper(), new f9.a(1));
                break;
            default:
                this.f4681c = Looper.myLooper();
                String name = Thread.currentThread().getName();
                this.f4680b = name != null && name.startsWith("IntentService[");
                break;
        }
    }

    public static a e(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("routes");
        if (parcelableArrayList != null) {
            for (int i10 = 0; i10 < parcelableArrayList.size(); i10++) {
                Bundle bundle2 = (Bundle) parcelableArrayList.get(i10);
                arrayList.add(bundle2 != null ? new i(bundle2) : null);
            }
        }
        return new a(arrayList, bundle.getBoolean("supportsDynamicGroupRoute", false));
    }

    public void a(int i10) {
        d.g(!this.f4680b);
        ((SparseBooleanArray) this.f4681c).append(i10, true);
    }

    public n b() {
        d.g(!this.f4680b);
        this.f4680b = true;
        return new n((SparseBooleanArray) this.f4681c);
    }

    public void c(String str) {
        Looper looper = (Looper) this.f4681c;
        String str2 = _UrlKt.FRAGMENT_ENCODE_SET;
        if (looper == null) {
            if (str != null) {
                str2 = str.concat(" Realm cannot be automatically updated on a thread without a looper.");
            }
            throw new IllegalStateException(str2);
        }
        if (this.f4680b) {
            if (str != null) {
                str2 = str.concat(" Realm cannot be automatically updated on an IntentService thread.");
            }
            throw new IllegalStateException(str2);
        }
    }

    public boolean d() {
        return this.f4680b;
    }

    public boolean f(CharSequence charSequence, int i10) {
        if (charSequence == null || i10 < 0 || charSequence.length() - i10 < 0) {
            throw new IllegalArgumentException();
        }
        f fVar = (f) this.f4681c;
        if (fVar == null) {
            return d();
        }
        fVar.getClass();
        char c10 = 2;
        for (int i11 = 0; i11 < i10 && c10 == 2; i11++) {
            byte directionality = Character.getDirectionality(charSequence.charAt(i11));
            a aVar = g.f7594a;
            if (directionality != 0) {
                if (directionality != 1 && directionality != 2) {
                    switch (directionality) {
                        case UrlRequest.Status.READING_RESPONSE /* 14 */:
                        case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                            break;
                        case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                        case 17:
                            break;
                        default:
                            c10 = 2;
                            break;
                    }
                }
                c10 = 0;
            }
            c10 = 1;
        }
        if (c10 == 0) {
            return true;
        }
        if (c10 != 1) {
            return d();
        }
        return false;
    }

    public synchronized void g(y yVar, boolean z10) {
        try {
            if (!this.f4680b && !z10) {
                this.f4680b = true;
                yVar.e();
                this.f4680b = false;
            }
            ((Handler) this.f4681c).obtainMessage(1, yVar).sendToTarget();
        } catch (Throwable th) {
            throw th;
        }
    }

    public String toString() {
        switch (this.f4679a) {
            case 5:
                StringBuilder sb2 = new StringBuilder("MediaRouteProviderDescriptor{ routes=");
                List list = (List) this.f4681c;
                sb2.append(Arrays.toString(list.toArray()));
                sb2.append(", isValid=");
                int size = list.size();
                boolean z10 = false;
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        z10 = true;
                    } else {
                        i iVar = (i) list.get(i10);
                        if (iVar != null && iVar.e()) {
                            i10++;
                        }
                    }
                }
                sb2.append(z10);
                sb2.append(" }");
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public a(ArrayList arrayList, boolean z10) {
        this.f4679a = 5;
        if (arrayList.isEmpty()) {
            this.f4681c = Collections.EMPTY_LIST;
        } else {
            this.f4681c = Collections.unmodifiableList(new ArrayList(arrayList));
        }
        this.f4680b = z10;
    }

    public a(f fVar, boolean z10) {
        this.f4679a = 2;
        this.f4679a = 2;
        this.f4681c = fVar;
        this.f4680b = z10;
    }

    public a(BottomSheetBehavior bottomSheetBehavior, boolean z10) {
        this.f4679a = 3;
        this.f4681c = bottomSheetBehavior;
        this.f4680b = z10;
    }
}
