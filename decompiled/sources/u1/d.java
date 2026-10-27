package u1;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final ContentResolver f12172a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f12173b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f12174c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, Handler handler, ContentResolver contentResolver, Uri uri) {
        super(handler);
        this.f12174c = eVar;
        this.f12172a = contentResolver;
        this.f12173b = uri;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        e eVar = this.f12174c;
        eVar.a(b.c(eVar.f12189a, eVar.f12196i, eVar.f12195h));
    }
}
