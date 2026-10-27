package j9;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class g extends c8.h implements k9.k {

    /* renamed from: c, reason: collision with root package name */
    public final i8.d f7280c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k f7281d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(k kVar, i8.d dVar) {
        super("com.google.android.play.core.assetpacks.protocol.IAssetModuleServiceCallback", 3);
        this.f7281d = kVar;
        this.f7280c = dVar;
    }

    @Override // k9.k
    public void C(Bundle bundle, Bundle bundle2) {
        this.f7281d.f7324e.d(this.f7280c);
        k.g.h("onKeepAlive(%b)", Boolean.valueOf(bundle.getBoolean("keep_alive")));
    }

    @Override // k9.k
    public void J(Bundle bundle) {
        k9.q qVar = this.f7281d.f7323d;
        i8.d dVar = this.f7280c;
        qVar.d(dVar);
        int i10 = bundle.getInt("error_code");
        k.g.f("onError(%d)", Integer.valueOf(i10));
        dVar.c(new a(i10));
    }

    @Override // k9.k
    public void S(List list) {
        this.f7281d.f7323d.d(this.f7280c);
        k.g.h("onGetSessionStates", new Object[0]);
    }

    @Override // k9.k
    public void W(Bundle bundle, Bundle bundle2) {
        this.f7281d.f7323d.d(this.f7280c);
        k.g.h("onGetChunkFileDescriptor", new Object[0]);
    }

    @Override // c8.h
    public final boolean w0(Parcel parcel, int i10) {
        i8.d dVar = this.f7280c;
        k kVar = this.f7281d;
        switch (i10) {
            case 2:
                int readInt = parcel.readInt();
                Parcelable.Creator creator = Bundle.CREATOR;
                k9.g.b(parcel);
                kVar.f7323d.d(dVar);
                k.g.h("onStartDownload(%d)", Integer.valueOf(readInt));
                return true;
            case 3:
                int readInt2 = parcel.readInt();
                Parcelable.Creator creator2 = Bundle.CREATOR;
                k9.g.b(parcel);
                kVar.f7323d.d(dVar);
                k.g.h("onCancelDownload(%d)", Integer.valueOf(readInt2));
                return true;
            case 4:
                int readInt3 = parcel.readInt();
                Parcelable.Creator creator3 = Bundle.CREATOR;
                k9.g.b(parcel);
                kVar.f7323d.d(dVar);
                k.g.h("onGetSession(%d)", Integer.valueOf(readInt3));
                return true;
            case 5:
                ArrayList createTypedArrayList = parcel.createTypedArrayList(Bundle.CREATOR);
                k9.g.b(parcel);
                S(createTypedArrayList);
                return true;
            case 6:
                Parcelable.Creator creator4 = Bundle.CREATOR;
                Bundle bundle = (Bundle) k9.g.a(parcel);
                k9.g.b(parcel);
                kVar.f7323d.d(dVar);
                k.g.h("onNotifyChunkTransferred(%s, %s, %d, session=%d)", bundle.getString("module_name"), bundle.getString("slice_id"), Integer.valueOf(bundle.getInt("chunk_number")), Integer.valueOf(bundle.getInt("session_id")));
                return true;
            case 7:
                Parcelable.Creator creator5 = Bundle.CREATOR;
                Bundle bundle2 = (Bundle) k9.g.a(parcel);
                k9.g.b(parcel);
                J(bundle2);
                return true;
            case 8:
                Parcelable.Creator creator6 = Bundle.CREATOR;
                Bundle bundle3 = (Bundle) k9.g.a(parcel);
                k9.g.b(parcel);
                kVar.f7323d.d(dVar);
                k.g.h("onNotifyModuleCompleted(%s, sessionId=%d)", bundle3.getString("module_name"), Integer.valueOf(bundle3.getInt("session_id")));
                return true;
            case 9:
            default:
                return false;
            case 10:
                Parcelable.Creator creator7 = Bundle.CREATOR;
                Bundle bundle4 = (Bundle) k9.g.a(parcel);
                k9.g.b(parcel);
                kVar.f7323d.d(dVar);
                k.g.h("onNotifySessionFailed(%d)", Integer.valueOf(bundle4.getInt("session_id")));
                return true;
            case 11:
                Parcelable.Creator creator8 = Bundle.CREATOR;
                Bundle bundle5 = (Bundle) k9.g.a(parcel);
                Bundle bundle6 = (Bundle) k9.g.a(parcel);
                k9.g.b(parcel);
                C(bundle5, bundle6);
                return true;
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                Parcelable.Creator creator9 = Bundle.CREATOR;
                Bundle bundle7 = (Bundle) k9.g.a(parcel);
                Bundle bundle8 = (Bundle) k9.g.a(parcel);
                k9.g.b(parcel);
                W(bundle7, bundle8);
                return true;
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                Parcelable.Creator creator10 = Bundle.CREATOR;
                k9.g.b(parcel);
                kVar.f7323d.d(dVar);
                k.g.h("onRequestDownloadInfo()", new Object[0]);
                return true;
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                Parcelable.Creator creator11 = Bundle.CREATOR;
                k9.g.b(parcel);
                kVar.f7323d.d(dVar);
                k.g.h("onRemoveModule()", new Object[0]);
                return true;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                Parcelable.Creator creator12 = Bundle.CREATOR;
                k9.g.b(parcel);
                kVar.f7323d.d(dVar);
                k.g.h("onCancelDownloads()", new Object[0]);
                return true;
        }
    }
}
