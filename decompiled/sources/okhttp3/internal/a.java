package okhttp3.internal;

import ya.l;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9709o;

    public /* synthetic */ a(int i10) {
        this.f9709o = i10;
    }

    @Override // ya.l
    public final Object invoke(Object obj) {
        LinkedTags string$lambda$0;
        CharSequence string$lambda$1;
        LinkedTags linkedTags = (LinkedTags) obj;
        switch (this.f9709o) {
            case 0:
                string$lambda$0 = LinkedTags.toString$lambda$0(linkedTags);
                return string$lambda$0;
            default:
                string$lambda$1 = LinkedTags.toString$lambda$1(linkedTags);
                return string$lambda$1;
        }
    }
}
