package k5;

import android.util.Log;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.internal.http.HttpStatusCodesKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f7823a = {65, 67, 122, 80, 111, 79, 78, 115, 76, 68, 75, 100, 104, 119, 120, 53, 77, 119, 99, 122, 63, 84, 84, 73, HttpStatusCodesKt.HTTP_SWITCHING_PROTOCOLS, 74, 75, 104, 70, 122, 65, 71};

    static {
        "0123456789abcdef".toCharArray();
    }

    public static String a(byte[] bArr) {
        try {
            int[] iArr = f7823a;
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < 32; i10++) {
                sb2.append((char) iArr[i10]);
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(sb2.toString().getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            return new String(cipher.doFinal(bArr));
        } catch (Exception e7) {
            Log.e("EnigmaUtils", "enigmatization", e7);
            return null;
        }
    }
}
