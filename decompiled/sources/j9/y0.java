package j9;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y0 implements x1 {

    /* renamed from: f, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7490f = new androidx.emoji2.text.s("FakeAssetPackService", 3);

    /* renamed from: a, reason: collision with root package name */
    public final String f7491a;

    /* renamed from: b, reason: collision with root package name */
    public final m f7492b;

    /* renamed from: c, reason: collision with root package name */
    public final j1 f7493c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f7494d = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    public final k9.e f7495e;

    static {
        new AtomicInteger(1);
    }

    public y0(File file, m mVar, Context context, j1 j1Var, k9.e eVar) {
        this.f7491a = file.getAbsolutePath();
        this.f7492b = mVar;
        this.f7493c = j1Var;
        this.f7495e = eVar;
    }

    @Override // j9.x1
    public final void a(List list) {
        f7490f.h("cancelDownload(%s)", list);
    }

    @Override // j9.x1
    public final void b(String str, String str2, int i10, int i11) {
        f7490f.h("notifyChunkTransferred", new Object[0]);
    }

    @Override // j9.x1
    public final void c(int i10) {
        f7490f.h("notifySessionFailed", new Object[0]);
    }

    @Override // j9.x1
    public final void d(int i10, String str) {
        f7490f.h("notifyModuleCompleted", new Object[0]);
        ((Executor) this.f7495e.c()).execute(new androidx.activity.h(this, i10, str));
    }

    @Override // j9.x1
    public final i8.i e(HashMap hashMap) {
        f7490f.h("syncPacks()", new Object[0]);
        ArrayList arrayList = new ArrayList();
        i8.i iVar = new i8.i();
        iVar.p(arrayList);
        return iVar;
    }

    @Override // j9.x1
    public final i8.i f(String str, String str2, int i10, int i11) {
        Object[] objArr = {Integer.valueOf(i10), str, str2, Integer.valueOf(i11)};
        androidx.emoji2.text.s sVar = f7490f;
        sVar.h("getChunkFileDescriptor(session=%d, %s, %s, %d)", objArr);
        i8.i iVar = new i8.i();
        try {
            for (File file : h(str)) {
                if (i7.e.a(file).equals(str2)) {
                    iVar.p(ParcelFileDescriptor.open(file, 268435456));
                    return iVar;
                }
            }
            throw new m9.a("Local testing slice for '" + str2 + "' not found.");
        } catch (FileNotFoundException e7) {
            sVar.i("getChunkFileDescriptor failed", e7);
            iVar.q(new m9.a("Asset Slice file not found.", e7));
            return iVar;
        } catch (m9.a e8) {
            sVar.i("getChunkFileDescriptor failed", e8);
            iVar.q(e8);
            return iVar;
        }
    }

    public final void g(int i10, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("app_version_code", this.f7493c.a());
        bundle.putInt("session_id", i10);
        File[] h10 = h(str);
        ArrayList<String> arrayList = new ArrayList<>();
        boolean z10 = false;
        long j10 = 0;
        for (File file : h10) {
            j10 += file.length();
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            arrayList2.add(null);
            String a10 = i7.e.a(file);
            bundle.putParcelableArrayList(com.bumptech.glide.e.b("chunk_intents", str, a10), arrayList2);
            try {
                bundle.putString(com.bumptech.glide.e.b("uncompressed_hash_sha256", str, a10), k0.b(Arrays.asList(file)));
                bundle.putLong(com.bumptech.glide.e.b("uncompressed_size", str, a10), file.length());
                arrayList.add(a10);
            } catch (IOException e7) {
                throw new m9.a(String.format("Could not digest file: %s.", file), e7);
            } catch (NoSuchAlgorithmException e8) {
                throw new m9.a("SHA256 algorithm not supported.", e8);
            }
        }
        bundle.putStringArrayList(com.bumptech.glide.e.a("slice_ids", str), arrayList);
        bundle.putLong(com.bumptech.glide.e.a("pack_version", str), r2.a());
        bundle.putInt(com.bumptech.glide.e.a("status", str), 4);
        bundle.putInt(com.bumptech.glide.e.a("error_code", str), 0);
        bundle.putLong(com.bumptech.glide.e.a("bytes_downloaded", str), j10);
        bundle.putLong(com.bumptech.glide.e.a("total_bytes_to_download", str), j10);
        bundle.putStringArrayList("pack_names", new ArrayList<>(Arrays.asList(str)));
        bundle.putLong("bytes_downloaded", j10);
        bundle.putLong("total_bytes_to_download", j10);
        this.f7494d.post(new app.shamel.tv.activities.y(this, new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE").putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle), 19, z10));
    }

    public final File[] h(String str) {
        File file = new File(this.f7491a);
        if (!file.isDirectory()) {
            throw new m9.a(String.format("Local testing directory '%s' not found.", file));
        }
        File[] listFiles = file.listFiles(new x0(str, 0));
        if (listFiles == null) {
            throw new m9.a(android.support.v4.media.d.q("Failed fetching APKs for pack '", str, "'."));
        }
        if (listFiles.length == 0) {
            throw new m9.a(android.support.v4.media.d.q("No APKs available for pack '", str, "'."));
        }
        for (File file2 : listFiles) {
            if (i7.e.a(file2).equals(str)) {
                return listFiles;
            }
        }
        throw new m9.a(android.support.v4.media.d.q("No main slice available for pack '", str, "'."));
    }

    @Override // j9.x1
    public final void f() {
        f7490f.h("keepAlive", new Object[0]);
    }
}
