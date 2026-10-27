package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends l {

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ int f3036s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(ContentResolver contentResolver, Uri uri, boolean z10, int i10) {
        super(contentResolver, uri, z10);
        this.f3036s = i10;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        switch (this.f3036s) {
            case 0:
                return AssetFileDescriptor.class;
            default:
                return ParcelFileDescriptor.class;
        }
    }

    @Override // com.bumptech.glide.load.data.l
    public final void e(Object obj) {
        switch (this.f3036s) {
            case 0:
                ((AssetFileDescriptor) obj).close();
                break;
            default:
                ((ParcelFileDescriptor) obj).close();
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006d  */
    @Override // com.bumptech.glide.load.data.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(android.content.ContentResolver r3, android.net.Uri r4) {
        /*
            r2 = this;
            int r3 = r2.f3036s
            switch(r3) {
                case 0: goto L45;
                default: goto L5;
            }
        L5:
            boolean r3 = r2.f3058o
            android.content.ContentResolver r0 = r2.f3060q
            if (r3 == 0) goto L24
            boolean r3 = w7.b.s(r4)
            if (r3 == 0) goto L24
            int r3 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r3 < r1) goto L24
            int r3 = n0.c.a()
            r1 = 17
            if (r3 < r1) goto L24
            android.content.res.AssetFileDescriptor r3 = s5.a.a(r0, r4)
            goto L2a
        L24:
            java.lang.String r3 = "r"
            android.content.res.AssetFileDescriptor r3 = r0.openAssetFileDescriptor(r4, r3)
        L2a:
            if (r3 == 0) goto L31
            android.os.ParcelFileDescriptor r3 = r3.getParcelFileDescriptor()
            return r3
        L31:
            java.io.FileNotFoundException r3 = new java.io.FileNotFoundException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "FileDescriptor is null for: "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        L45:
            boolean r3 = r2.f3058o
            android.content.ContentResolver r0 = r2.f3060q
            if (r3 == 0) goto L64
            boolean r3 = w7.b.s(r4)
            if (r3 == 0) goto L64
            int r3 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r3 < r1) goto L64
            int r3 = n0.c.a()
            r1 = 17
            if (r3 < r1) goto L64
            android.content.res.AssetFileDescriptor r3 = s5.a.a(r0, r4)
            goto L6a
        L64:
            java.lang.String r3 = "r"
            android.content.res.AssetFileDescriptor r3 = r0.openAssetFileDescriptor(r4, r3)
        L6a:
            if (r3 == 0) goto L6d
            return r3
        L6d:
            java.io.FileNotFoundException r3 = new java.io.FileNotFoundException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "FileDescriptor is null for: "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.a.f(android.content.ContentResolver, android.net.Uri):java.lang.Object");
    }
}
