package q3;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l1.a0;
import l1.t;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f10309a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)((?:.|\\f)*)?$");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f10310b = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: c, reason: collision with root package name */
    public static final Map f10311c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map f10312d;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f10311c = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f10312d = Collections.unmodifiableMap(hashMap2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(String str, e eVar, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        char c10;
        int i10;
        int i11;
        int i12;
        int i13 = eVar.f10294b;
        int length = spannableStringBuilder.length();
        String str2 = eVar.f10293a;
        str2.getClass();
        int i14 = -1;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals(_UrlKt.FRAGMENT_ENCODE_SET)) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case 98:
                if (str2.equals("b")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case 99:
                if (str2.equals("c")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case 105:
                if (str2.equals("i")) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            case 117:
                if (str2.equals("u")) {
                    c10 = 4;
                    break;
                }
                c10 = 65535;
                break;
            case 118:
                if (str2.equals("v")) {
                    c10 = 5;
                    break;
                }
                c10 = 65535;
                break;
            case 3314158:
                if (str2.equals("lang")) {
                    c10 = 6;
                    break;
                }
                c10 = 65535;
                break;
            case 3511770:
                if (str2.equals("ruby")) {
                    c10 = 7;
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        switch (c10) {
            case 0:
            case 6:
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(1), i13, length, 33);
                break;
            case 2:
                for (String str3 : eVar.f10296d) {
                    Map map = f10311c;
                    if (map.containsKey(str3)) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str3)).intValue()), i13, length, 33);
                    } else {
                        Map map2 = f10312d;
                        if (map2.containsKey(str3)) {
                            spannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer) map2.get(str3)).intValue()), i13, length, 33);
                        }
                    }
                }
                break;
            case 3:
                spannableStringBuilder.setSpan(new StyleSpan(2), i13, length, 33);
                break;
            case 4:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i13, length, 33);
                break;
            case 5:
                spannableStringBuilder.setSpan(new k1.i(eVar.f10295c), i13, length, 33);
                break;
            case 7:
                int c11 = c(list2, str, eVar);
                ArrayList arrayList = new ArrayList(list.size());
                arrayList.addAll(list);
                Collections.sort(arrayList, d.f10290c);
                int i15 = eVar.f10294b;
                int i16 = 0;
                int i17 = 0;
                while (i16 < arrayList.size()) {
                    if ("rt".equals(((d) arrayList.get(i16)).f10291a.f10293a)) {
                        d dVar = (d) arrayList.get(i16);
                        int c12 = c(list2, str, dVar.f10291a);
                        if (c12 == i14) {
                            c12 = c11 != i14 ? c11 : 1;
                        }
                        int i18 = dVar.f10291a.f10294b - i17;
                        int i19 = dVar.f10292b - i17;
                        CharSequence subSequence = spannableStringBuilder.subSequence(i18, i19);
                        spannableStringBuilder.delete(i18, i19);
                        spannableStringBuilder.setSpan(new k1.g(subSequence.toString(), c12), i15, i18, 33);
                        i17 = subSequence.length() + i17;
                        i15 = i18;
                    }
                    i16++;
                    i14 = -1;
                }
                break;
            default:
                return;
        }
        ArrayList b2 = b(list2, str, eVar);
        for (int i20 = 0; i20 < b2.size(); i20++) {
            b bVar = ((f) b2.get(i20)).f10298p;
            int i21 = bVar.f10281l;
            if (i21 == -1 && bVar.f10282m == -1) {
                i10 = -1;
            } else {
                i10 = (bVar.f10282m == 1 ? (char) 2 : (char) 0) | (i21 == 1 ? (char) 1 : (char) 0);
            }
            if (i10 != -1) {
                int i22 = bVar.f10281l;
                if (i22 == -1 && bVar.f10282m == -1) {
                    i12 = -1;
                    i11 = 1;
                } else {
                    i11 = 1;
                    i12 = (i22 == 1 ? 1 : 0) | (bVar.f10282m == 1 ? 2 : 0);
                }
                com.bumptech.glide.d.a(spannableStringBuilder, new StyleSpan(i12), i13, length);
            } else {
                i11 = 1;
            }
            if (bVar.f10279j == i11) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i13, length, 33);
            }
            if (bVar.f10280k == i11) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i13, length, 33);
            }
            if (bVar.g) {
                if (!bVar.g) {
                    throw new IllegalStateException("Font color not defined");
                }
                com.bumptech.glide.d.a(spannableStringBuilder, new ForegroundColorSpan(bVar.f10276f), i13, length);
            }
            if (bVar.f10278i) {
                if (!bVar.f10278i) {
                    throw new IllegalStateException("Background color not defined.");
                }
                com.bumptech.glide.d.a(spannableStringBuilder, new BackgroundColorSpan(bVar.f10277h), i13, length);
            }
            if (bVar.f10275e != null) {
                com.bumptech.glide.d.a(spannableStringBuilder, new TypefaceSpan(bVar.f10275e), i13, length);
            }
            int i23 = bVar.f10283n;
            if (i23 == 1) {
                com.bumptech.glide.d.a(spannableStringBuilder, new AbsoluteSizeSpan((int) bVar.f10284o, true), i13, length);
            } else if (i23 == 2) {
                com.bumptech.glide.d.a(spannableStringBuilder, new RelativeSizeSpan(bVar.f10284o), i13, length);
            } else if (i23 == 3) {
                com.bumptech.glide.d.a(spannableStringBuilder, new RelativeSizeSpan(bVar.f10284o / 100.0f), i13, length);
            }
            if (bVar.f10286q) {
                spannableStringBuilder.setSpan(new k1.e(), i13, length, 33);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList b(List list, String str, e eVar) {
        int size;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            b bVar = (b) list.get(i10);
            String str2 = eVar.f10293a;
            Set set = eVar.f10296d;
            String str3 = eVar.f10295c;
            if (bVar.f10271a.isEmpty() && bVar.f10272b.isEmpty() && bVar.f10273c.isEmpty() && bVar.f10274d.isEmpty()) {
                size = TextUtils.isEmpty(str2);
            } else {
                int a10 = b.a(bVar.f10274d, str3, b.a(bVar.f10272b, str2, b.a(bVar.f10271a, str, 0, 1073741824), 2), 4);
                size = (a10 == -1 || !set.containsAll(bVar.f10273c)) ? 0 : a10 + (bVar.f10273c.size() * 4);
            }
            if (size > 0) {
                arrayList.add(new f(size, bVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static int c(List list, String str, e eVar) {
        ArrayList b2 = b(list, str, eVar);
        for (int i10 = 0; i10 < b2.size(); i10++) {
            int i11 = ((f) b2.get(i10)).f10298p.f10285p;
            if (i11 != -1) {
                return i11;
            }
        }
        return -1;
    }

    public static c d(String str, Matcher matcher, t tVar, ArrayList arrayList) {
        g gVar = new g();
        try {
            String group = matcher.group(1);
            group.getClass();
            gVar.f10299a = i.c(group);
            String group2 = matcher.group(2);
            group2.getClass();
            gVar.f10300b = i.c(group2);
            String group3 = matcher.group(3);
            group3.getClass();
            e(group3, gVar);
            StringBuilder sb2 = new StringBuilder();
            tVar.getClass();
            String k10 = tVar.k(StandardCharsets.UTF_8);
            while (!TextUtils.isEmpty(k10)) {
                if (sb2.length() > 0) {
                    sb2.append("\n");
                }
                sb2.append(k10.trim());
                k10 = tVar.k(StandardCharsets.UTF_8);
            }
            gVar.f10301c = f(str, sb2.toString(), arrayList);
            return new c(gVar.a().a(), gVar.f10299a, gVar.f10300b);
        } catch (IllegalArgumentException unused) {
            l1.b.q("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0081, code lost:
    
        if (r6.equals("center") == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c5, code lost:
    
        if (r7.equals("start") == false) goto L53;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(java.lang.String r18, q3.g r19) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.h.e(java.lang.String, q3.g):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static SpannedString f(String str, String str2, List list) {
        char c10;
        char c11;
        String substring;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (true) {
            int length = str2.length();
            String str3 = _UrlKt.FRAGMENT_ENCODE_SET;
            if (i10 >= length) {
                while (!arrayDeque.isEmpty()) {
                    a(str, (e) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
                }
                a(str, new e(_UrlKt.FRAGMENT_ENCODE_SET, 0, _UrlKt.FRAGMENT_ENCODE_SET, Collections.EMPTY_SET), Collections.EMPTY_LIST, spannableStringBuilder, list);
                return SpannedString.valueOf(spannableStringBuilder);
            }
            char charAt = str2.charAt(i10);
            if (charAt == '&') {
                i10++;
                int indexOf = str2.indexOf(59, i10);
                int indexOf2 = str2.indexOf(32, i10);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    substring = str2.substring(i10, indexOf);
                    substring.getClass();
                    switch (substring) {
                        case "gt":
                            spannableStringBuilder.append('>');
                            break;
                        case "lt":
                            spannableStringBuilder.append('<');
                            break;
                        case "amp":
                            spannableStringBuilder.append('&');
                            break;
                        case "nbsp":
                            spannableStringBuilder.append(' ');
                            break;
                        default:
                            l1.b.q("WebvttCueParser", "ignoring unsupported entity: '&" + substring + ";'");
                            break;
                    }
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i10 = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i10++;
            } else {
                int i11 = i10 + 1;
                if (i11 < str2.length()) {
                    boolean z10 = str2.charAt(i11) == '/';
                    int indexOf3 = str2.indexOf(62, i11);
                    i11 = indexOf3 == -1 ? str2.length() : indexOf3 + 1;
                    int i12 = i11 - 2;
                    boolean z11 = str2.charAt(i12) == '/';
                    int i13 = i10 + (z10 ? 2 : 1);
                    if (!z11) {
                        i12 = i11 - 1;
                    }
                    String substring2 = str2.substring(i13, i12);
                    if (!substring2.trim().isEmpty()) {
                        String trim = substring2.trim();
                        l1.d.b(!trim.isEmpty());
                        int i14 = a0.f8067a;
                        String str4 = trim.split("[ \\.]", 2)[0];
                        str4.getClass();
                        switch (str4.hashCode()) {
                            case 98:
                                if (str4.equals("b")) {
                                    c10 = 0;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 99:
                                if (str4.equals("c")) {
                                    c10 = 1;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 105:
                                if (str4.equals("i")) {
                                    c10 = 2;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 117:
                                if (str4.equals("u")) {
                                    c10 = 3;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 118:
                                if (str4.equals("v")) {
                                    c10 = 4;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 3650:
                                if (str4.equals("rt")) {
                                    c10 = 5;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 3314158:
                                if (str4.equals("lang")) {
                                    c10 = 6;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 3511770:
                                if (str4.equals("ruby")) {
                                    c10 = 7;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            default:
                                c10 = 65535;
                                break;
                        }
                        switch (c10) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                if (z10) {
                                    while (!arrayDeque.isEmpty()) {
                                        e eVar = (e) arrayDeque.pop();
                                        a(str, eVar, arrayList, spannableStringBuilder, list);
                                        if (arrayDeque.isEmpty()) {
                                            arrayList.clear();
                                        } else {
                                            arrayList.add(new d(eVar, spannableStringBuilder.length()));
                                        }
                                        if (eVar.f10293a.equals(str4)) {
                                            break;
                                        }
                                    }
                                    break;
                                } else if (!z11) {
                                    int length2 = spannableStringBuilder.length();
                                    String trim2 = substring2.trim();
                                    l1.d.b(!trim2.isEmpty());
                                    int indexOf4 = trim2.indexOf(" ");
                                    if (indexOf4 == -1) {
                                        c11 = 0;
                                    } else {
                                        str3 = trim2.substring(indexOf4).trim();
                                        c11 = 0;
                                        trim2 = trim2.substring(0, indexOf4);
                                    }
                                    String[] split = trim2.split("\\.", -1);
                                    String str5 = split[c11];
                                    HashSet hashSet = new HashSet();
                                    for (int i15 = 1; i15 < split.length; i15++) {
                                        hashSet.add(split[i15]);
                                    }
                                    arrayDeque.push(new e(str5, length2, str3, hashSet));
                                    break;
                                }
                                break;
                        }
                    }
                }
                i10 = i11;
            }
        }
    }

    public static void g(String str, g gVar) {
        String substring;
        int i10;
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            substring = str.substring(indexOf + 1);
            substring.getClass();
            i10 = 2;
            switch (substring) {
                case "center":
                case "middle":
                    i10 = 1;
                    break;
                case "end":
                    break;
                case "start":
                    i10 = 0;
                    break;
                default:
                    l1.b.q("WebvttCueParser", "Invalid anchor value: ".concat(substring));
                    i10 = Integer.MIN_VALUE;
                    break;
            }
            gVar.g = i10;
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            gVar.f10303e = i.b(str);
            gVar.f10304f = 0;
        } else {
            gVar.f10303e = Integer.parseInt(str);
            gVar.f10304f = 1;
        }
    }
}
