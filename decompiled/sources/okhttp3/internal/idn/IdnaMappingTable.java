package okhttp3.internal.idn;

import rb.m;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class IdnaMappingTable {
    private final String mappings;
    private final String ranges;
    private final String sections;

    public IdnaMappingTable(String str, String str2, String str3) {
        h.e("sections", str);
        h.e("ranges", str2);
        h.e("mappings", str3);
        this.sections = str;
        this.ranges = str2;
        this.mappings = str3;
    }

    private final int findRangesOffset(int i10, int i11, int i12) {
        int i13;
        int i14 = i10 & 127;
        int i15 = i12 - 1;
        while (true) {
            if (i11 > i15) {
                i13 = (-i11) - 1;
                break;
            }
            i13 = (i11 + i15) / 2;
            int f10 = h.f(i14, this.ranges.charAt(i13 * 4));
            if (f10 >= 0) {
                if (f10 <= 0) {
                    break;
                }
                i11 = i13 + 1;
            } else {
                i15 = i13 - 1;
            }
        }
        return i13 >= 0 ? i13 * 4 : ((-i13) - 2) * 4;
    }

    private final int findSectionsIndex(int i10) {
        int i11;
        int i12 = (i10 & 2097024) >> 7;
        int length = (this.sections.length() / 4) - 1;
        int i13 = 0;
        while (true) {
            if (i13 > length) {
                i11 = (-i13) - 1;
                break;
            }
            i11 = (i13 + length) / 2;
            int f10 = h.f(i12, IdnaMappingTableKt.read14BitInt(this.sections, i11 * 4));
            if (f10 >= 0) {
                if (f10 <= 0) {
                    break;
                }
                i13 = i11 + 1;
            } else {
                length = i11 - 1;
            }
        }
        return i11 >= 0 ? i11 * 4 : ((-i11) - 2) * 4;
    }

    public final String getMappings() {
        return this.mappings;
    }

    public final String getRanges() {
        return this.ranges;
    }

    public final String getSections() {
        return this.sections;
    }

    public final boolean map(int i10, m mVar) {
        h.e("sink", mVar);
        int findSectionsIndex = findSectionsIndex(i10);
        int findRangesOffset = findRangesOffset(i10, IdnaMappingTableKt.read14BitInt(this.sections, findSectionsIndex + 2), findSectionsIndex + 4 < this.sections.length() ? IdnaMappingTableKt.read14BitInt(this.sections, findSectionsIndex + 6) : this.ranges.length() / 4);
        char charAt = this.ranges.charAt(findRangesOffset + 1);
        if (charAt >= 0 && charAt < '@') {
            int read14BitInt = IdnaMappingTableKt.read14BitInt(this.ranges, findRangesOffset + 2);
            mVar.f(this.mappings, read14BitInt, charAt + read14BitInt);
            return true;
        }
        if ('@' <= charAt && charAt < 'P') {
            mVar.m(i10 - (this.ranges.charAt(findRangesOffset + 3) | (((charAt & 15) << 14) | (this.ranges.charAt(findRangesOffset + 2) << 7))));
            return true;
        }
        if ('P' <= charAt && charAt < '`') {
            mVar.m(i10 + (this.ranges.charAt(findRangesOffset + 3) | ((charAt & 15) << 14) | (this.ranges.charAt(findRangesOffset + 2) << 7)));
            return true;
        }
        if (charAt == 'w') {
            return true;
        }
        if (charAt == 'x') {
            mVar.m(i10);
            return true;
        }
        if (charAt == 'y') {
            mVar.m(i10);
            return false;
        }
        if (charAt == 'z') {
            mVar.writeByte(this.ranges.charAt(findRangesOffset + 2));
            return true;
        }
        if (charAt == '{') {
            mVar.writeByte(this.ranges.charAt(findRangesOffset + 2) | 128);
            return true;
        }
        if (charAt == '|') {
            mVar.writeByte(this.ranges.charAt(findRangesOffset + 2));
            mVar.writeByte(this.ranges.charAt(findRangesOffset + 3));
            return true;
        }
        if (charAt == '}') {
            mVar.writeByte(this.ranges.charAt(findRangesOffset + 2) | 128);
            mVar.writeByte(this.ranges.charAt(findRangesOffset + 3));
            return true;
        }
        if (charAt == '~') {
            mVar.writeByte(this.ranges.charAt(findRangesOffset + 2));
            mVar.writeByte(this.ranges.charAt(findRangesOffset + 3) | 128);
            return true;
        }
        if (charAt == 127) {
            mVar.writeByte(this.ranges.charAt(findRangesOffset + 2) | 128);
            mVar.writeByte(this.ranges.charAt(findRangesOffset + 3) | 128);
            return true;
        }
        throw new IllegalStateException(("unexpected rangesIndex for " + i10).toString());
    }
}
