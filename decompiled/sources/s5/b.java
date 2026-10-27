package s5;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f11573c = {"_data"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f11574d = {"_data"};

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11575a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentResolver f11576b;

    public /* synthetic */ b(ContentResolver contentResolver, int i10) {
        this.f11575a = i10;
        this.f11576b = contentResolver;
    }

    @Override // s5.d
    public final Cursor a(Uri uri) {
        switch (this.f11575a) {
            case 0:
                String lastPathSegment = uri.getLastPathSegment();
                return this.f11576b.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f11573c, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
            default:
                String lastPathSegment2 = uri.getLastPathSegment();
                return this.f11576b.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f11574d, "kind = 1 AND video_id = ?", new String[]{lastPathSegment2}, null);
        }
    }
}
