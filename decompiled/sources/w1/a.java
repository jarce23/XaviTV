package w1;

import android.net.Uri;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import o1.e0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements o1.h {

    /* renamed from: o, reason: collision with root package name */
    public final o1.h f12750o;

    /* renamed from: p, reason: collision with root package name */
    public final byte[] f12751p;

    /* renamed from: q, reason: collision with root package name */
    public final byte[] f12752q;

    /* renamed from: r, reason: collision with root package name */
    public CipherInputStream f12753r;

    public a(o1.h hVar, byte[] bArr, byte[] bArr2) {
        this.f12750o = hVar;
        this.f12751p = bArr;
        this.f12752q = bArr2;
    }

    @Override // o1.h
    public final void close() {
        if (this.f12753r != null) {
            this.f12753r = null;
            this.f12750o.close();
        }
    }

    @Override // o1.h
    public final Map e() {
        return this.f12750o.e();
    }

    @Override // o1.h
    public final void g(e0 e0Var) {
        e0Var.getClass();
        this.f12750o.g(e0Var);
    }

    @Override // o1.h
    public final long j(o1.l lVar) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                cipher.init(2, new SecretKeySpec(this.f12751p, "AES"), new IvParameterSpec(this.f12752q));
                o1.j jVar = new o1.j(this.f12750o, lVar);
                this.f12753r = new CipherInputStream(jVar, cipher);
                jVar.a();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e7) {
                throw new RuntimeException(e7);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e8) {
            throw new RuntimeException(e8);
        }
    }

    @Override // o1.h
    public final Uri l() {
        return this.f12750o.l();
    }

    @Override // i1.h
    public final int read(byte[] bArr, int i10, int i11) {
        this.f12753r.getClass();
        int read = this.f12753r.read(bArr, i10, i11);
        if (read < 0) {
            return -1;
        }
        return read;
    }
}
