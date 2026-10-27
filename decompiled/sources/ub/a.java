package ub;

import okhttp3.internal.http.HttpStatusCodesKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public enum a {
    /* JADX INFO: Fake field, exist only in values array */
    IMG_NOT_CONFINED(0, 0),
    OPEN_FAILED(1, HttpStatusCodesKt.HTTP_SWITCHING_PROTOCOLS),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_BYTE_BUFFER(2, HttpStatusCodesKt.HTTP_PROCESSING),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_GIF_FILE(3, HttpStatusCodesKt.HTTP_EARLY_HINTS),
    /* JADX INFO: Fake field, exist only in values array */
    NO_SCRN_DSCR(4, 104),
    /* JADX INFO: Fake field, exist only in values array */
    NO_IMAG_DSCR(5, 105),
    /* JADX INFO: Fake field, exist only in values array */
    NO_COLOR_MAP(6, 106),
    /* JADX INFO: Fake field, exist only in values array */
    WRONG_RECORD(7, 107),
    /* JADX INFO: Fake field, exist only in values array */
    DATA_TOO_BIG(8, 108),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_ENOUGH_MEM(9, 109),
    /* JADX INFO: Fake field, exist only in values array */
    CLOSE_FAILED(10, 110),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_READABLE(11, 111),
    /* JADX INFO: Fake field, exist only in values array */
    IMAGE_DEFECT(12, 112),
    /* JADX INFO: Fake field, exist only in values array */
    EOF_TOO_SOON(13, 113),
    /* JADX INFO: Fake field, exist only in values array */
    IMG_NOT_CONFINED(14, 1000),
    /* JADX INFO: Fake field, exist only in values array */
    REWIND_FAILED(15, WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_BYTE_BUFFER(16, 1002),
    /* JADX INFO: Fake field, exist only in values array */
    IMG_NOT_CONFINED(17, 1003),
    /* JADX INFO: Fake field, exist only in values array */
    REWIND_FAILED(18, 1004),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_BYTE_BUFFER(19, WebSocketProtocol.CLOSE_NO_STATUS_CODE),
    UNKNOWN(20, -1);


    /* renamed from: o, reason: collision with root package name */
    public final String f12570o;

    /* renamed from: p, reason: collision with root package name */
    public int f12571p;

    a(int i10, int i11) {
        this.f12571p = i11;
        this.f12570o = r2;
    }
}
