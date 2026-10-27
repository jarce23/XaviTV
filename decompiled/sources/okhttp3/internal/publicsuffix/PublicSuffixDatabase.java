package okhttp3.internal.publicsuffix;

import android.support.v4.media.d;
import com.bumptech.glide.f;
import fb.c;
import gb.a;
import gb.i;
import j9.w1;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import ma.j;
import ma.p;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.url._UrlKt;
import rb.o;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class PublicSuffixDatabase {
    public static final Companion Companion = new Companion(null);
    private static final char EXCEPTION_MARKER = '!';
    private static final List<String> PREVAILING_RULE;
    private static final o WILDCARD_LABEL;
    private static PublicSuffixDatabase instance;
    private final PublicSuffixList publicSuffixList;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String binarySearch(o oVar, o[] oVarArr, int i10) {
            int i11;
            int and;
            boolean z10;
            int and2;
            int d6 = oVar.d();
            int i12 = 0;
            while (i12 < d6) {
                int i13 = (i12 + d6) / 2;
                while (i13 > -1 && oVar.i(i13) != 10) {
                    i13--;
                }
                int i14 = i13 + 1;
                int i15 = 1;
                while (true) {
                    i11 = i14 + i15;
                    if (oVar.i(i11) == 10) {
                        break;
                    }
                    i15++;
                }
                int i16 = i11 - i14;
                int i17 = i10;
                boolean z11 = false;
                int i18 = 0;
                int i19 = 0;
                while (true) {
                    if (z11) {
                        and = 46;
                        z10 = false;
                    } else {
                        boolean z12 = z11;
                        and = _UtilCommonKt.and(oVarArr[i17].i(i18), 255);
                        z10 = z12;
                    }
                    and2 = and - _UtilCommonKt.and(oVar.i(i14 + i19), 255);
                    if (and2 != 0) {
                        break;
                    }
                    i19++;
                    i18++;
                    if (i19 == i16) {
                        break;
                    }
                    if (oVarArr[i17].d() != i18) {
                        z11 = z10;
                    } else {
                        if (i17 == oVarArr.length - 1) {
                            break;
                        }
                        i17++;
                        z11 = true;
                        i18 = -1;
                    }
                }
                if (and2 >= 0) {
                    if (and2 <= 0) {
                        int i20 = i16 - i19;
                        int d10 = oVarArr[i17].d() - i18;
                        int length = oVarArr.length;
                        for (int i21 = i17 + 1; i21 < length; i21++) {
                            d10 += oVarArr[i21].d();
                        }
                        if (d10 >= i20) {
                            if (d10 <= i20) {
                                return oVar.o(i14, i16 + i14).n(a.f5445a);
                            }
                        }
                    }
                    i12 = i11 + 1;
                }
                d6 = i13;
            }
            return null;
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        public final void resetForTests$okhttp() {
            PublicSuffixDatabase.instance = new PublicSuffixDatabase(PublicSuffixList_androidKt.getDefault(PublicSuffixList.Companion));
        }

        private Companion() {
        }
    }

    static {
        o oVar = o.f11048r;
        byte[] copyOf = Arrays.copyOf(new byte[]{42}, 1);
        h.d("copyOf(...)", copyOf);
        WILDCARD_LABEL = new o(copyOf);
        PREVAILING_RULE = f.t("*");
        instance = new PublicSuffixDatabase(PublicSuffixList_androidKt.getDefault(PublicSuffixList.Companion));
    }

    public PublicSuffixDatabase(PublicSuffixList publicSuffixList) {
        h.e("publicSuffixList", publicSuffixList);
        this.publicSuffixList = publicSuffixList;
    }

    private final List<String> findMatchingRule(List<String> list) {
        String str;
        String str2;
        String str3;
        this.publicSuffixList.ensureLoaded();
        int size = list.size();
        o[] oVarArr = new o[size];
        for (int i10 = 0; i10 < size; i10++) {
            o oVar = o.f11048r;
            oVarArr[i10] = w1.F(list.get(i10));
        }
        int i11 = 0;
        while (true) {
            str = null;
            if (i11 >= size) {
                str2 = null;
                break;
            }
            str2 = Companion.binarySearch(this.publicSuffixList.getBytes(), oVarArr, i11);
            if (str2 != null) {
                break;
            }
            i11++;
        }
        if (size > 1) {
            o[] oVarArr2 = (o[]) oVarArr.clone();
            int length = oVarArr2.length - 1;
            for (int i12 = 0; i12 < length; i12++) {
                oVarArr2[i12] = WILDCARD_LABEL;
                str3 = Companion.binarySearch(this.publicSuffixList.getBytes(), oVarArr2, i12);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            int i13 = size - 1;
            int i14 = 0;
            while (true) {
                if (i14 >= i13) {
                    break;
                }
                String binarySearch = Companion.binarySearch(this.publicSuffixList.getExceptionBytes(), oVarArr, i14);
                if (binarySearch != null) {
                    str = binarySearch;
                    break;
                }
                i14++;
            }
        }
        if (str != null) {
            return i.l0("!".concat(str), new char[]{'.'});
        }
        if (str2 == null && str3 == null) {
            return PREVAILING_RULE;
        }
        List<String> list2 = p.f9051o;
        List<String> l02 = str2 != null ? i.l0(str2, new char[]{'.'}) : list2;
        if (str3 != null) {
            list2 = i.l0(str3, new char[]{'.'});
        }
        return l02.size() > list2.size() ? l02 : list2;
    }

    private final List<String> splitDomain(String str) {
        List<String> l02 = i.l0(str, new char[]{'.'});
        if (!h.a(j.G(l02), _UrlKt.FRAGMENT_ENCODE_SET)) {
            return l02;
        }
        int size = l02.size() - 1;
        if (size < 0) {
            size = 0;
        }
        if (size < 0) {
            throw new IllegalArgumentException(d.o("Requested element count ", size, " is less than zero.").toString());
        }
        p pVar = p.f9051o;
        if (size == 0) {
            return pVar;
        }
        if (size >= l02.size()) {
            return j.J(l02);
        }
        if (size == 1) {
            if (l02.isEmpty()) {
                throw new NoSuchElementException("List is empty.");
            }
            return f.t(l02.get(0));
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator<T> it = l02.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i10++;
            if (i10 == size) {
                break;
            }
        }
        int size2 = arrayList.size();
        return size2 != 0 ? size2 != 1 ? arrayList : f.t(arrayList.get(0)) : pVar;
    }

    public final String getEffectiveTldPlusOne(String str) {
        int size;
        int size2;
        h.e("domain", str);
        String unicode = IDN.toUnicode(str);
        h.b(unicode);
        List<String> splitDomain = splitDomain(unicode);
        List<String> findMatchingRule = findMatchingRule(splitDomain);
        int i10 = 0;
        if (splitDomain.size() == findMatchingRule.size() && findMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (findMatchingRule.get(0).charAt(0) == '!') {
            size = splitDomain.size();
            size2 = findMatchingRule.size();
        } else {
            size = splitDomain.size();
            size2 = findMatchingRule.size() + 1;
        }
        int i11 = size - size2;
        List<String> splitDomain2 = splitDomain(str);
        h.e("<this>", splitDomain2);
        fb.f iVar = new fb.i(2, splitDomain2);
        if (i11 < 0) {
            throw new IllegalArgumentException(d.o("Requested element count ", i11, " is less than zero.").toString());
        }
        if (i11 != 0) {
            iVar = new c(iVar, i11);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) _UrlKt.FRAGMENT_ENCODE_SET);
        for (Object obj : iVar) {
            i10++;
            if (i10 > 1) {
                sb2.append((CharSequence) ".");
            }
            com.bumptech.glide.d.b(sb2, obj, null);
        }
        sb2.append((CharSequence) _UrlKt.FRAGMENT_ENCODE_SET);
        return sb2.toString();
    }
}
