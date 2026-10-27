package androidx.leanback.widget.picker;

import a1.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import androidx.activity.j;
import c1.c;
import c1.d;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import x4.e;
import x4.f;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class DatePicker extends c {
    public static final int[] Q = {5, 2, 1};
    public String D;
    public d E;
    public d F;
    public d G;
    public int H;
    public int I;
    public int J;
    public final SimpleDateFormat K;
    public final e L;
    public final Calendar M;
    public final Calendar N;
    public final Calendar O;
    public final Calendar P;

    public DatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.K = new SimpleDateFormat("MM/dd/yyyy");
        Locale locale = Locale.getDefault();
        getContext().getResources();
        this.L = new e(locale);
        this.P = f.z(this.P, locale);
        this.M = f.z(this.M, (Locale) this.L.f13542p);
        this.N = f.z(this.N, (Locale) this.L.f13542p);
        this.O = f.z(this.O, (Locale) this.L.f13542p);
        d dVar = this.E;
        if (dVar != null) {
            dVar.f2516d = (String[]) this.L.f13543q;
            a(this.H, dVar);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f12d);
        String string = obtainStyledAttributes.getString(0);
        String string2 = obtainStyledAttributes.getString(1);
        this.P.clear();
        if (TextUtils.isEmpty(string)) {
            this.P.set(1900, 0, 1);
        } else if (!g(string, this.P)) {
            this.P.set(1900, 0, 1);
        }
        this.M.setTimeInMillis(this.P.getTimeInMillis());
        this.P.clear();
        if (TextUtils.isEmpty(string2)) {
            this.P.set(2100, 0, 1);
        } else if (!g(string2, this.P)) {
            this.P.set(2100, 0, 1);
        }
        this.N.setTimeInMillis(this.P.getTimeInMillis());
        String string3 = obtainStyledAttributes.getString(2);
        setDatePickerFormat(TextUtils.isEmpty(string3) ? new String(DateFormat.getDateFormatOrder(context)) : string3);
    }

    public final boolean g(String str, Calendar calendar) {
        try {
            calendar.setTime(this.K.parse(str));
            return true;
        } catch (ParseException unused) {
            Log.w("DatePicker", "Date: " + str + " not in format: MM/dd/yyyy");
            return false;
        }
    }

    public long getDate() {
        return this.O.getTimeInMillis();
    }

    public String getDatePickerFormat() {
        return this.D;
    }

    public long getMaxDate() {
        return this.N.getTimeInMillis();
    }

    public long getMinDate() {
        return this.M.getTimeInMillis();
    }

    public void setDatePickerFormat(String str) {
        if (TextUtils.isEmpty(str)) {
            str = new String(DateFormat.getDateFormatOrder(getContext()));
        }
        if (TextUtils.equals(this.D, str)) {
            return;
        }
        this.D = str;
        e eVar = this.L;
        String bestDateTimePattern = DateFormat.getBestDateTimePattern((Locale) eVar.f13542p, str);
        if (TextUtils.isEmpty(bestDateTimePattern)) {
            bestDateTimePattern = "MM/dd/yyyy";
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        char[] cArr = {'Y', 'y', 'M', 'm', 'D', 'd'};
        boolean z10 = false;
        char c10 = 0;
        for (int i10 = 0; i10 < bestDateTimePattern.length(); i10++) {
            char charAt = bestDateTimePattern.charAt(i10);
            if (charAt != ' ') {
                if (charAt != '\'') {
                    if (!z10) {
                        int i11 = 0;
                        while (true) {
                            if (i11 >= 6) {
                                sb2.append(charAt);
                                break;
                            } else if (charAt != cArr[i11]) {
                                i11++;
                            } else if (charAt != c10) {
                                arrayList.add(sb2.toString());
                                sb2.setLength(0);
                            }
                        }
                    } else {
                        sb2.append(charAt);
                    }
                    c10 = charAt;
                } else if (z10) {
                    z10 = false;
                } else {
                    sb2.setLength(0);
                    z10 = true;
                }
            }
        }
        arrayList.add(sb2.toString());
        if (arrayList.size() != str.length() + 1) {
            throw new IllegalStateException("Separators size: " + arrayList.size() + " must equal the size of datePickerFormat: " + str.length() + " + 1");
        }
        setSeparators(arrayList);
        this.F = null;
        this.E = null;
        this.G = null;
        this.H = -1;
        this.I = -1;
        this.J = -1;
        String upperCase = str.toUpperCase();
        ArrayList arrayList2 = new ArrayList(3);
        for (int i12 = 0; i12 < upperCase.length(); i12++) {
            char charAt2 = upperCase.charAt(i12);
            if (charAt2 == 'D') {
                if (this.F != null) {
                    throw new IllegalArgumentException("datePicker format error");
                }
                d dVar = new d();
                this.F = dVar;
                arrayList2.add(dVar);
                this.F.f2517e = "%02d";
                this.I = i12;
            } else if (charAt2 != 'M') {
                if (charAt2 != 'Y') {
                    throw new IllegalArgumentException("datePicker format error");
                }
                if (this.G != null) {
                    throw new IllegalArgumentException("datePicker format error");
                }
                d dVar2 = new d();
                this.G = dVar2;
                arrayList2.add(dVar2);
                this.J = i12;
                this.G.f2517e = "%d";
            } else {
                if (this.E != null) {
                    throw new IllegalArgumentException("datePicker format error");
                }
                d dVar3 = new d();
                this.E = dVar3;
                arrayList2.add(dVar3);
                this.E.f2516d = (String[]) eVar.f13543q;
                this.H = i12;
            }
        }
        setColumns(arrayList2);
        post(new j(11, this));
    }

    public void setMaxDate(long j10) {
        this.P.setTimeInMillis(j10);
        if (this.P.get(1) != this.N.get(1) || this.P.get(6) == this.N.get(6)) {
            this.N.setTimeInMillis(j10);
            if (this.O.after(this.N)) {
                this.O.setTimeInMillis(this.N.getTimeInMillis());
            }
            post(new j(11, this));
        }
    }

    public void setMinDate(long j10) {
        this.P.setTimeInMillis(j10);
        if (this.P.get(1) != this.M.get(1) || this.P.get(6) == this.M.get(6)) {
            this.M.setTimeInMillis(j10);
            if (this.O.before(this.M)) {
                this.O.setTimeInMillis(this.M.getTimeInMillis());
            }
            post(new j(11, this));
        }
    }
}
