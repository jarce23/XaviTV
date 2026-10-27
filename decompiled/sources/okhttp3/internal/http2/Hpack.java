package okhttp3.internal.http2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ma.i;
import ma.j;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.url._UrlKt;
import rb.l;
import rb.n;
import rb.o;
import rb.s0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Hpack {
    public static final Hpack INSTANCE;
    private static final Map<o, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    private static final Header[] STATIC_HEADER_TABLE;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Reader {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final n source;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Reader(s0 s0Var, int i10) {
            this(s0Var, i10, 0, 4, null);
            za.h.e("source", s0Var);
        }

        private final void adjustDynamicTableByteCount() {
            int i10 = this.maxDynamicTableByteCount;
            int i11 = this.dynamicTableByteCount;
            if (i10 < i11) {
                if (i10 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i11 - i10);
                }
            }
        }

        private final void clearDynamicTable() {
            i.I(r0, null, 0, this.dynamicTable.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int i10) {
            return this.nextHeaderIndex + 1 + i10;
        }

        private final int evictToRecoverBytes(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i11 = this.nextHeaderIndex;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    za.h.b(header);
                    int i13 = header.hpackSize;
                    i10 -= i13;
                    this.dynamicTableByteCount -= i13;
                    this.headerCount--;
                    i12++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i11 + 1, headerArr, i11 + 1 + i12, this.headerCount);
                this.nextHeaderIndex += i12;
            }
            return i12;
        }

        private final o getName(int i10) {
            if (isStaticHeader(i10)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i10].name;
            }
            int dynamicTableIndex = dynamicTableIndex(i10 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    Header header = headerArr[dynamicTableIndex];
                    za.h.b(header);
                    return header.name;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        private final void insertIntoDynamicTable(int i10, Header header) {
            this.headerList.add(header);
            int i11 = header.hpackSize;
            if (i10 != -1) {
                Header header2 = this.dynamicTable[dynamicTableIndex(i10)];
                za.h.b(header2);
                i11 -= header2.hpackSize;
            }
            int i12 = this.maxDynamicTableByteCount;
            if (i11 > i12) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i11) - i12);
            if (i10 == -1) {
                int i13 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i13 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i14 = this.nextHeaderIndex;
                this.nextHeaderIndex = i14 - 1;
                this.dynamicTable[i14] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[dynamicTableIndex(i10) + evictToRecoverBytes + i10] = header;
            }
            this.dynamicTableByteCount += i11;
        }

        private final boolean isStaticHeader(int i10) {
            return i10 >= 0 && i10 <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final int readByte() {
            return _UtilCommonKt.and(this.source.readByte(), 255);
        }

        private final void readIndexedHeader(int i10) {
            if (isStaticHeader(i10)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i10]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i10 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    List<Header> list = this.headerList;
                    Header header = headerArr[dynamicTableIndex];
                    za.h.b(header);
                    list.add(header);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i10) {
            insertIntoDynamicTable(-1, new Header(getName(i10), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i10) {
            this.headerList.add(new Header(getName(i10), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        public final List<Header> getAndResetHeaderList() {
            List<Header> J = j.J(this.headerList);
            this.headerList.clear();
            return J;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public final o readByteString() {
            int readByte = readByte();
            boolean z10 = (readByte & 128) == 128;
            long readInt = readInt(readByte, 127);
            if (!z10) {
                return this.source.i(readInt);
            }
            l lVar = new l();
            Huffman.INSTANCE.decode(this.source, readInt, lVar);
            return lVar.i(lVar.f11035p);
        }

        public final void readHeaders() {
            while (!this.source.t()) {
                int and = _UtilCommonKt.and(this.source.readByte(), 255);
                if (and == 128) {
                    throw new IOException("index == 0");
                }
                if ((and & 128) == 128) {
                    readIndexedHeader(readInt(and, 127) - 1);
                } else if (and == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((and & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(and, Hpack.PREFIX_6_BITS) - 1);
                } else if ((and & 32) == 32) {
                    int readInt = readInt(and, Hpack.PREFIX_5_BITS);
                    this.maxDynamicTableByteCount = readInt;
                    if (readInt < 0 || readInt > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (and == 16 || and == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(and, 15) - 1);
                }
            }
        }

        public final int readInt(int i10, int i11) {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i11 + (readByte << i13);
                }
                i11 += (readByte & 127) << i13;
                i13 += 7;
            }
        }

        public Reader(s0 s0Var, int i10, int i11) {
            za.h.e("source", s0Var);
            this.headerTableSizeSetting = i10;
            this.maxDynamicTableByteCount = i11;
            this.headerList = new ArrayList();
            this.source = rb.b.c(s0Var);
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = 7;
        }

        public /* synthetic */ Reader(s0 s0Var, int i10, int i11, int i12, za.e eVar) {
            this(s0Var, i10, (i12 & 4) != 0 ? i10 : i11);
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Writer {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final l out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Writer(int i10, l lVar) {
            this(i10, false, lVar, 2, null);
            za.h.e("out", lVar);
        }

        private final void adjustDynamicTableByteCount() {
            int i10 = this.maxDynamicTableByteCount;
            int i11 = this.dynamicTableByteCount;
            if (i10 < i11) {
                if (i10 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i11 - i10);
                }
            }
        }

        private final void clearDynamicTable() {
            i.I(r0, null, 0, this.dynamicTable.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i11 = this.nextHeaderIndex;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    za.h.b(header);
                    i10 -= header.hpackSize;
                    int i13 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    za.h.b(header2);
                    this.dynamicTableByteCount = i13 - header2.hpackSize;
                    this.headerCount--;
                    i12++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i11 + 1, headerArr, i11 + 1 + i12, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i14 = this.nextHeaderIndex;
                Arrays.fill(headerArr2, i14 + 1, i14 + 1 + i12, (Object) null);
                this.nextHeaderIndex += i12;
            }
            return i12;
        }

        private final void insertIntoDynamicTable(Header header) {
            int i10 = header.hpackSize;
            int i11 = this.maxDynamicTableByteCount;
            if (i10 > i11) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i10) - i11);
            int i12 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i12 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i13 = this.nextHeaderIndex;
            this.nextHeaderIndex = i13 - 1;
            this.dynamicTable[i13] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i10;
        }

        public final void resizeHeaderTable(int i10) {
            this.headerTableSizeSetting = i10;
            int min = Math.min(i10, 16384);
            int i11 = this.maxDynamicTableByteCount;
            if (i11 == min) {
                return;
            }
            if (min < i11) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = min;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(o oVar) {
            za.h.e("data", oVar);
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(oVar) < oVar.d()) {
                    l lVar = new l();
                    huffman.encode(oVar, lVar);
                    o i10 = lVar.i(lVar.f11035p);
                    writeInt(i10.d(), 127, 128);
                    this.out.W(i10);
                    return;
                }
            }
            writeInt(oVar.d(), 127, 0);
            this.out.W(oVar);
        }

        public final void writeHeaders(List<Header> list) {
            int i10;
            int i11;
            za.h.e("headerBlock", list);
            if (this.emitDynamicTableSizeUpdate) {
                int i12 = this.smallestHeaderTableSizeSetting;
                if (i12 < this.maxDynamicTableByteCount) {
                    writeInt(i12, Hpack.PREFIX_5_BITS, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, Hpack.PREFIX_5_BITS, 32);
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                Header header = list.get(i13);
                o q10 = header.name.q();
                o oVar = header.value;
                Hpack hpack = Hpack.INSTANCE;
                Integer num = hpack.getNAME_TO_FIRST_INDEX().get(q10);
                if (num != null) {
                    int intValue = num.intValue();
                    i11 = intValue + 1;
                    if (2 <= i11 && i11 < 8) {
                        if (za.h.a(hpack.getSTATIC_HEADER_TABLE()[intValue].value, oVar)) {
                            i10 = i11;
                        } else if (za.h.a(hpack.getSTATIC_HEADER_TABLE()[i11].value, oVar)) {
                            i10 = i11;
                            i11 = intValue + 2;
                        }
                    }
                    i10 = i11;
                    i11 = -1;
                } else {
                    i10 = -1;
                    i11 = -1;
                }
                if (i11 == -1) {
                    int i14 = this.nextHeaderIndex + 1;
                    int length = this.dynamicTable.length;
                    while (true) {
                        if (i14 >= length) {
                            break;
                        }
                        Header header2 = this.dynamicTable[i14];
                        za.h.b(header2);
                        if (za.h.a(header2.name, q10)) {
                            Header header3 = this.dynamicTable[i14];
                            za.h.b(header3);
                            if (za.h.a(header3.value, oVar)) {
                                i11 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (i14 - this.nextHeaderIndex);
                                break;
                            } else if (i10 == -1) {
                                i10 = (i14 - this.nextHeaderIndex) + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
                            }
                        }
                        i14++;
                    }
                }
                if (i11 != -1) {
                    writeInt(i11, 127, 128);
                } else if (i10 == -1) {
                    this.out.X(64);
                    writeByteString(q10);
                    writeByteString(oVar);
                    insertIntoDynamicTable(header);
                } else {
                    o oVar2 = Header.PSEUDO_PREFIX;
                    q10.getClass();
                    za.h.e("prefix", oVar2);
                    if (!q10.m(0, oVar2, oVar2.d()) || za.h.a(Header.TARGET_AUTHORITY, q10)) {
                        writeInt(i10, Hpack.PREFIX_6_BITS, 64);
                        writeByteString(oVar);
                        insertIntoDynamicTable(header);
                    } else {
                        writeInt(i10, 15, 0);
                        writeByteString(oVar);
                    }
                }
            }
        }

        public final void writeInt(int i10, int i11, int i12) {
            if (i10 < i11) {
                this.out.X(i10 | i12);
                return;
            }
            this.out.X(i12 | i11);
            int i13 = i10 - i11;
            while (i13 >= 128) {
                this.out.X(128 | (i13 & 127));
                i13 >>>= 7;
            }
            this.out.X(i13);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Writer(l lVar) {
            this(0, false, lVar, 3, null);
            za.h.e("out", lVar);
        }

        public Writer(int i10, boolean z10, l lVar) {
            za.h.e("out", lVar);
            this.headerTableSizeSetting = i10;
            this.useCompression = z10;
            this.out = lVar;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i10;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = r2.length - 1;
        }

        public /* synthetic */ Writer(int i10, boolean z10, l lVar, int i11, za.e eVar) {
            this((i11 & 1) != 0 ? Hpack.SETTINGS_HEADER_TABLE_SIZE : i10, (i11 & 2) != 0 ? true : z10, lVar);
        }
    }

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        Header header = new Header(Header.TARGET_AUTHORITY, _UrlKt.FRAGMENT_ENCODE_SET);
        o oVar = Header.TARGET_METHOD;
        Header header2 = new Header(oVar, "GET");
        Header header3 = new Header(oVar, "POST");
        o oVar2 = Header.TARGET_PATH;
        Header header4 = new Header(oVar2, "/");
        Header header5 = new Header(oVar2, "/index.html");
        o oVar3 = Header.TARGET_SCHEME;
        Header header6 = new Header(oVar3, "http");
        Header header7 = new Header(oVar3, "https");
        o oVar4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{header, header2, header3, header4, header5, header6, header7, new Header(oVar4, "200"), new Header(oVar4, "204"), new Header(oVar4, "206"), new Header(oVar4, "304"), new Header(oVar4, "400"), new Header(oVar4, "404"), new Header(oVar4, "500"), new Header("accept-charset", _UrlKt.FRAGMENT_ENCODE_SET), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", _UrlKt.FRAGMENT_ENCODE_SET), new Header("accept-ranges", _UrlKt.FRAGMENT_ENCODE_SET), new Header("accept", _UrlKt.FRAGMENT_ENCODE_SET), new Header("access-control-allow-origin", _UrlKt.FRAGMENT_ENCODE_SET), new Header("age", _UrlKt.FRAGMENT_ENCODE_SET), new Header("allow", _UrlKt.FRAGMENT_ENCODE_SET), new Header("authorization", _UrlKt.FRAGMENT_ENCODE_SET), new Header("cache-control", _UrlKt.FRAGMENT_ENCODE_SET), new Header("content-disposition", _UrlKt.FRAGMENT_ENCODE_SET), new Header("content-encoding", _UrlKt.FRAGMENT_ENCODE_SET), new Header("content-language", _UrlKt.FRAGMENT_ENCODE_SET), new Header("content-length", _UrlKt.FRAGMENT_ENCODE_SET), new Header("content-location", _UrlKt.FRAGMENT_ENCODE_SET), new Header("content-range", _UrlKt.FRAGMENT_ENCODE_SET), new Header("content-type", _UrlKt.FRAGMENT_ENCODE_SET), new Header("cookie", _UrlKt.FRAGMENT_ENCODE_SET), new Header("date", _UrlKt.FRAGMENT_ENCODE_SET), new Header("etag", _UrlKt.FRAGMENT_ENCODE_SET), new Header("expect", _UrlKt.FRAGMENT_ENCODE_SET), new Header("expires", _UrlKt.FRAGMENT_ENCODE_SET), new Header("from", _UrlKt.FRAGMENT_ENCODE_SET), new Header("host", _UrlKt.FRAGMENT_ENCODE_SET), new Header("if-match", _UrlKt.FRAGMENT_ENCODE_SET), new Header("if-modified-since", _UrlKt.FRAGMENT_ENCODE_SET), new Header("if-none-match", _UrlKt.FRAGMENT_ENCODE_SET), new Header("if-range", _UrlKt.FRAGMENT_ENCODE_SET), new Header("if-unmodified-since", _UrlKt.FRAGMENT_ENCODE_SET), new Header("last-modified", _UrlKt.FRAGMENT_ENCODE_SET), new Header("link", _UrlKt.FRAGMENT_ENCODE_SET), new Header("location", _UrlKt.FRAGMENT_ENCODE_SET), new Header("max-forwards", _UrlKt.FRAGMENT_ENCODE_SET), new Header("proxy-authenticate", _UrlKt.FRAGMENT_ENCODE_SET), new Header("proxy-authorization", _UrlKt.FRAGMENT_ENCODE_SET), new Header("range", _UrlKt.FRAGMENT_ENCODE_SET), new Header("referer", _UrlKt.FRAGMENT_ENCODE_SET), new Header("refresh", _UrlKt.FRAGMENT_ENCODE_SET), new Header("retry-after", _UrlKt.FRAGMENT_ENCODE_SET), new Header("server", _UrlKt.FRAGMENT_ENCODE_SET), new Header("set-cookie", _UrlKt.FRAGMENT_ENCODE_SET), new Header("strict-transport-security", _UrlKt.FRAGMENT_ENCODE_SET), new Header("transfer-encoding", _UrlKt.FRAGMENT_ENCODE_SET), new Header("user-agent", _UrlKt.FRAGMENT_ENCODE_SET), new Header("vary", _UrlKt.FRAGMENT_ENCODE_SET), new Header("via", _UrlKt.FRAGMENT_ENCODE_SET), new Header("www-authenticate", _UrlKt.FRAGMENT_ENCODE_SET)};
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<o, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length, 1.0f);
        int length = headerArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i10].name)) {
                linkedHashMap.put(headerArr2[i10].name, Integer.valueOf(i10));
            }
        }
        Map<o, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        za.h.d("unmodifiableMap(...)", unmodifiableMap);
        return unmodifiableMap;
    }

    public final o checkLowercase(o oVar) {
        za.h.e("name", oVar);
        int d6 = oVar.d();
        for (int i10 = 0; i10 < d6; i10++) {
            byte i11 = oVar.i(i10);
            if (65 <= i11 && i11 < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(oVar.r()));
            }
        }
        return oVar;
    }

    public final Map<o, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }
}
