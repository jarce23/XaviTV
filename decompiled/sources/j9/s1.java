package j9;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s1 {

    /* renamed from: b, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7439b = new androidx.emoji2.text.s("VerifySliceTaskHandler", 3);

    /* renamed from: a, reason: collision with root package name */
    public final p f7440a;

    public s1(p pVar) {
        this.f7440a = pVar;
    }

    public final void a(r1 r1Var) {
        String str = r1Var.f7474b;
        String str2 = r1Var.f7474b;
        String str3 = r1Var.f7429e;
        int i10 = r1Var.f7473a;
        File i11 = this.f7440a.i(str2, r1Var.f7427c, r1Var.f7428d, str3);
        if (!i11.exists()) {
            throw new j0(android.support.v4.media.d.q("Cannot find unverified files for slice ", str3, "."), i10);
        }
        try {
            p pVar = this.f7440a;
            String str4 = r1Var.f7429e;
            int i12 = r1Var.f7427c;
            long j10 = r1Var.f7428d;
            pVar.getClass();
            File file = new File(new File(new File(pVar.c(i12, str, j10), "_slices"), "_metadata"), str4);
            if (!file.exists()) {
                throw new j0("Cannot find metadata files for slice " + str4 + ".", i10);
            }
            try {
                if (!k0.b(q1.a(i11, file)).equals(r1Var.f7430f)) {
                    throw new j0(android.support.v4.media.d.q("Verification failed for slice ", str4, "."), i10);
                }
                f7439b.h("Verification of slice %s of pack %s successful.", str4, str);
                File j11 = this.f7440a.j(r1Var.f7474b, r1Var.f7427c, r1Var.f7428d, r1Var.f7429e);
                if (!j11.exists()) {
                    j11.mkdirs();
                }
                if (!i11.renameTo(j11)) {
                    throw new j0(android.support.v4.media.d.q("Failed to move slice ", str3, " after verification."), i10);
                }
            } catch (IOException e7) {
                throw new j0(android.support.v4.media.d.q("Could not digest file during verification for slice ", str3, "."), e7, i10);
            } catch (NoSuchAlgorithmException e8) {
                throw new j0("SHA256 algorithm not supported.", e8, i10);
            }
        } catch (IOException e10) {
            throw new j0(android.support.v4.media.d.q("Could not reconstruct slice archive during verification for slice ", str3, "."), e10, i10);
        }
    }
}
