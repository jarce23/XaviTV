package gb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class i extends p {
    public static boolean a0(CharSequence charSequence, char c10) {
        za.h.e("<this>", charSequence);
        return e0(charSequence, c10, 0, 2) >= 0;
    }

    public static boolean b0(String str, String str2) {
        za.h.e("<this>", str);
        return f0(str, str2, 0, 2) >= 0;
    }

    public static final int c0(CharSequence charSequence) {
        za.h.e("<this>", charSequence);
        return charSequence.length() - 1;
    }

    public static final int d0(CharSequence charSequence, String str, int i10, boolean z10) {
        za.h.e("<this>", charSequence);
        za.h.e("string", str);
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i10);
        }
        int length = charSequence.length();
        if (i10 < 0) {
            i10 = 0;
        }
        int length2 = charSequence.length();
        if (length > length2) {
            length = length2;
        }
        db.c cVar = new db.c(i10, length, 1);
        boolean z11 = charSequence instanceof String;
        int i11 = cVar.f4352q;
        int i12 = cVar.f4351p;
        int i13 = cVar.f4350o;
        if (z11 && (str instanceof String)) {
            if ((i11 <= 0 || i13 > i12) && (i11 >= 0 || i12 > i13)) {
                return -1;
            }
            int i14 = i13;
            while (true) {
                String str2 = str;
                boolean z12 = z10;
                if (p.U(0, i14, str.length(), str2, (String) charSequence, z12)) {
                    return i14;
                }
                if (i14 == i12) {
                    return -1;
                }
                i14 += i11;
                str = str2;
                z10 = z12;
            }
        } else {
            if ((i11 <= 0 || i13 > i12) && (i11 >= 0 || i12 > i13)) {
                return -1;
            }
            while (true) {
                int length3 = str.length();
                za.h.e("<this>", str);
                za.h.e("other", charSequence);
                boolean z13 = false;
                if (i13 >= 0 && str.length() - length3 >= 0 && i13 <= charSequence.length() - length3) {
                    int i15 = 0;
                    while (true) {
                        if (i15 >= length3) {
                            z13 = true;
                            break;
                        }
                        if (!com.bumptech.glide.c.i(str.charAt(0 + i15), charSequence.charAt(i13 + i15), z10)) {
                            break;
                        }
                        i15++;
                    }
                }
                if (z13) {
                    return i13;
                }
                if (i13 == i12) {
                    return -1;
                }
                i13 += i11;
            }
        }
    }

    public static int e0(CharSequence charSequence, char c10, int i10, int i11) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        za.h.e("<this>", charSequence);
        return !(charSequence instanceof String) ? g0(charSequence, new char[]{c10}, i10, false) : ((String) charSequence).indexOf(c10, i10);
    }

    public static /* synthetic */ int f0(CharSequence charSequence, String str, int i10, int i11) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return d0(charSequence, str, i10, false);
    }

    public static final int g0(CharSequence charSequence, char[] cArr, int i10, boolean z10) {
        za.h.e("<this>", charSequence);
        if (!z10 && cArr.length == 1 && (charSequence instanceof String)) {
            int length = cArr.length;
            if (length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            if (length != 1) {
                throw new IllegalArgumentException("Array has more than one element.");
            }
            return ((String) charSequence).indexOf(cArr[0], i10);
        }
        if (i10 < 0) {
            i10 = 0;
        }
        int c02 = c0(charSequence);
        if (i10 > c02) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(i10);
            for (char c10 : cArr) {
                if (com.bumptech.glide.c.i(c10, charAt, z10)) {
                    return i10;
                }
            }
            if (i10 == c02) {
                return -1;
            }
            i10++;
        }
    }

    public static boolean h0(String str) {
        za.h.e("<this>", str);
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (!com.bumptech.glide.c.q(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static int i0(String str, char c10, int i10, int i11) {
        if ((i11 & 2) != 0) {
            i10 = c0(str);
        }
        za.h.e("<this>", str);
        return str.lastIndexOf(c10, i10);
    }

    public static String j0(String str) {
        CharSequence charSequence;
        if (8 <= str.length()) {
            charSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb2 = new StringBuilder(8);
            int length = 8 - str.length();
            int i10 = 1;
            if (1 <= length) {
                while (true) {
                    sb2.append('0');
                    if (i10 == length) {
                        break;
                    }
                    i10++;
                }
            }
            sb2.append((CharSequence) str);
            charSequence = sb2;
        }
        return charSequence.toString();
    }

    public static String k0(String str, String str2) {
        if (!p.Y(str, str2, false)) {
            return str;
        }
        String substring = str.substring(str2.length());
        za.h.d("substring(...)", substring);
        return substring;
    }

    public static List l0(String str, char[] cArr) {
        za.h.e("<this>", str);
        if (cArr.length == 1) {
            String valueOf = String.valueOf(cArr[0]);
            int d02 = d0(str, valueOf, 0, false);
            if (d02 == -1) {
                return com.bumptech.glide.f.t(str.toString());
            }
            ArrayList arrayList = new ArrayList(10);
            int i10 = 0;
            do {
                arrayList.add(str.subSequence(i10, d02).toString());
                i10 = valueOf.length() + d02;
                d02 = d0(str, valueOf, i10, false);
            } while (d02 != -1);
            arrayList.add(str.subSequence(i10, str.length()).toString());
            return arrayList;
        }
        fb.j jVar = new fb.j(new fb.e(str, new q(cArr)));
        ArrayList arrayList2 = new ArrayList(ma.l.z(jVar));
        Iterator it = jVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList2;
            }
            db.c cVar = (db.c) bVar.next();
            za.h.e("range", cVar);
            arrayList2.add(str.subSequence(cVar.f4350o, cVar.f4351p + 1).toString());
        }
    }

    public static String m0(String str, String str2) {
        za.h.e("delimiter", str2);
        int f02 = f0(str, str2, 0, 6);
        if (f02 == -1) {
            return str;
        }
        String substring = str.substring(str2.length() + f02, str.length());
        za.h.d("substring(...)", substring);
        return substring;
    }

    public static String n0(int i10, String str) {
        za.h.e("<this>", str);
        if (i10 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.o("Requested character count ", i10, " is less than zero.").toString());
        }
        int length = str.length();
        if (i10 > length) {
            i10 = length;
        }
        String substring = str.substring(0, i10);
        za.h.d("substring(...)", substring);
        return substring;
    }

    public static CharSequence o0(String str) {
        za.h.e("<this>", str);
        int length = str.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean q10 = com.bumptech.glide.c.q(str.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!q10) {
                    break;
                }
                length--;
            } else if (q10) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return str.subSequence(i10, length + 1);
    }
}
