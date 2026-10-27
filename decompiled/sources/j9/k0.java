package j9;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class k0 {

    /* renamed from: a, reason: collision with root package name */
    public static x4.m f7326a;

    /* renamed from: b, reason: collision with root package name */
    public static final n7.i f7327b = new n7.i(27);

    /* renamed from: c, reason: collision with root package name */
    public static final n7.i f7328c = new n7.i(28);

    /* renamed from: d, reason: collision with root package name */
    public static final z9.e f7329d = new z9.e();

    /* renamed from: e, reason: collision with root package name */
    public static final v1 f7330e;

    /* renamed from: f, reason: collision with root package name */
    public static final w1 f7331f;

    static {
        int i10 = 0;
        f7330e = new v1(i10);
        f7331f = new w1(i10);
    }

    public static int a(int i10, byte[] bArr) {
        return ((bArr[i10 + 1] & 255) << 8) | (bArr[i10] & 255);
    }

    public static String b(List list) {
        int read;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA256");
        byte[] bArr = new byte[8192];
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FileInputStream fileInputStream = new FileInputStream((File) it.next());
            do {
                try {
                    read = fileInputStream.read(bArr);
                    if (read > 0) {
                        messageDigest.update(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } while (read != -1);
            fileInputStream.close();
        }
        return Base64.encodeToString(messageDigest.digest(), 11);
    }

    public static synchronized x4.m c(Context context) {
        x4.m mVar;
        synchronized (k0.class) {
            try {
                if (f7326a == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    f7326a = new x4.m(new androidx.emoji2.text.o(context, false));
                }
                mVar = f7326a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    public static boolean d(int i10) {
        return i10 == 2 || i10 == 7 || i10 == 3;
    }

    public static o4.f e(Bundle bundle, Bundle bundle2) {
        com.bumptech.glide.h hVar = new com.bumptech.glide.h(1);
        hVar.f3017a.put("BUNDLE_DATA_CONVERTER_VERSION", "1.0");
        h(new x4.m("session_bundle:", bundle, hVar, 12));
        g(new x4.m("notification_bundle:", bundle2, hVar, 12));
        o4.f fVar = new o4.f(hVar.f3017a);
        o4.f.b(fVar);
        return fVar;
    }

    public static boolean f(int i10, int i11) {
        if (i10 == 5) {
            if (i11 != 5) {
                return true;
            }
            i10 = 5;
        }
        if (i10 == 6) {
            if (i11 != 6 && i11 != 5) {
                return true;
            }
            i10 = 6;
        }
        if (i10 == 4 && i11 != 4) {
            return true;
        }
        if (i10 == 3 && (i11 == 2 || i11 == 7 || i11 == 1 || i11 == 8)) {
            return true;
        }
        if (i10 == 2) {
            return i11 == 1 || i11 == 8;
        }
        return false;
    }

    public static void g(v vVar) {
        vVar.p("notification_channel_name");
        vVar.p("notification_title");
        vVar.p("notification_subtext");
        vVar.q("notification_color");
        vVar.h(600000L, "notification_timeout");
        vVar.j();
        vVar.p("notification_intent_component_class_name");
        vVar.p("notification_intent_component_package_name");
        vVar.p("notification_intent_package");
        vVar.p("notification_intent_action");
        vVar.p("notification_intent_data");
        vVar.q("notification_intent_flags");
        vVar.p("notification_intent_extra_error_dialog_document_id");
    }

    public static void h(v vVar) {
        vVar.q("session_id");
        vVar.q("app_version_code");
        ArrayList g = vVar.g("pack_names");
        int size = g.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = g.get(i10);
            i10++;
            String str = (String) obj;
            vVar.f(com.bumptech.glide.e.a("pack_version", str));
            vVar.p(com.bumptech.glide.e.a("pack_version_tag", str));
            vVar.q(com.bumptech.glide.e.a("status", str));
            vVar.f(com.bumptech.glide.e.a("total_bytes_to_download", str));
            ArrayList g6 = vVar.g(com.bumptech.glide.e.a("slice_ids", str));
            int size2 = g6.size();
            int i11 = 0;
            while (i11 < size2) {
                Object obj2 = g6.get(i11);
                i11++;
                String str2 = (String) obj2;
                vVar.k(com.bumptech.glide.e.b("chunk_intents", str, str2));
                vVar.p(com.bumptech.glide.e.b("uncompressed_hash_sha256", str, str2));
                vVar.f(com.bumptech.glide.e.b("uncompressed_size", str, str2));
                vVar.q(com.bumptech.glide.e.b("patch_format", str, str2));
                vVar.q(com.bumptech.glide.e.b("compression_format", str, str2));
            }
        }
    }
}
