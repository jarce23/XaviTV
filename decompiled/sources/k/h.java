package k;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import java.io.IOException;
import l.o;
import m.i1;
import okhttp3.internal.http2.Settings;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f7563e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f7564f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f7565a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f7566b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f7567c;

    /* renamed from: d, reason: collision with root package name */
    public Object f7568d;

    static {
        Class[] clsArr = {Context.class};
        f7563e = clsArr;
        f7564f = clsArr;
    }

    public h(Context context) {
        super(context);
        this.f7567c = context;
        Object[] objArr = {context};
        this.f7565a = objArr;
        this.f7566b = objArr;
    }

    public static Object a(Object obj) {
        return obj instanceof Activity ? obj : obj instanceof ContextWrapper ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public final void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        int i10;
        XmlPullParser xmlPullParser2;
        ColorStateList colorStateList;
        int resourceId;
        g gVar = new g(this, menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            i10 = 2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z10 = false;
        boolean z11 = false;
        String str = null;
        while (!z10) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != i10) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z11 && name2.equals(str)) {
                        xmlPullParser2 = xmlPullParser;
                        z11 = false;
                        str = null;
                        eventType = xmlPullParser2.next();
                        i10 = 2;
                        z10 = z10;
                        z11 = z11;
                    } else if (name2.equals("group")) {
                        gVar.f7539b = 0;
                        gVar.f7540c = 0;
                        gVar.f7541d = 0;
                        gVar.f7542e = 0;
                        gVar.f7543f = true;
                        gVar.g = true;
                    } else if (name2.equals("item")) {
                        if (!gVar.f7544h) {
                            o oVar = gVar.f7562z;
                            if (oVar == null || !oVar.f8040b.hasSubMenu()) {
                                gVar.f7544h = true;
                                gVar.b(gVar.f7538a.add(gVar.f7539b, gVar.f7545i, gVar.f7546j, gVar.f7547k));
                            } else {
                                gVar.f7544h = true;
                                gVar.b(gVar.f7538a.addSubMenu(gVar.f7539b, gVar.f7545i, gVar.f7546j, gVar.f7547k).getItem());
                            }
                        }
                    } else if (name2.equals("menu")) {
                        xmlPullParser2 = xmlPullParser;
                        z10 = true;
                    }
                }
                xmlPullParser2 = xmlPullParser;
                z10 = z10;
            } else {
                if (!z11) {
                    String name3 = xmlPullParser.getName();
                    boolean equals = name3.equals("group");
                    Context context = this.f7567c;
                    if (equals) {
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.a.f4372p);
                        gVar.f7539b = obtainStyledAttributes.getResourceId(1, 0);
                        gVar.f7540c = obtainStyledAttributes.getInt(3, 0);
                        gVar.f7541d = obtainStyledAttributes.getInt(4, 0);
                        gVar.f7542e = obtainStyledAttributes.getInt(5, 0);
                        gVar.f7543f = obtainStyledAttributes.getBoolean(2, true);
                        gVar.g = obtainStyledAttributes.getBoolean(0, true);
                        obtainStyledAttributes.recycle();
                    } else {
                        if (name3.equals("item")) {
                            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, e.a.f4373q);
                            gVar.f7545i = obtainStyledAttributes2.getResourceId(2, 0);
                            gVar.f7546j = (obtainStyledAttributes2.getInt(5, gVar.f7540c) & (-65536)) | (obtainStyledAttributes2.getInt(6, gVar.f7541d) & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                            gVar.f7547k = obtainStyledAttributes2.getText(7);
                            gVar.f7548l = obtainStyledAttributes2.getText(8);
                            gVar.f7549m = obtainStyledAttributes2.getResourceId(0, 0);
                            String string = obtainStyledAttributes2.getString(9);
                            gVar.f7550n = string == null ? (char) 0 : string.charAt(0);
                            gVar.f7551o = obtainStyledAttributes2.getInt(16, 4096);
                            String string2 = obtainStyledAttributes2.getString(10);
                            gVar.f7552p = string2 == null ? (char) 0 : string2.charAt(0);
                            gVar.f7553q = obtainStyledAttributes2.getInt(20, 4096);
                            if (obtainStyledAttributes2.hasValue(11)) {
                                gVar.f7554r = obtainStyledAttributes2.getBoolean(11, false) ? 1 : 0;
                            } else {
                                gVar.f7554r = gVar.f7542e;
                            }
                            gVar.f7555s = obtainStyledAttributes2.getBoolean(3, false);
                            gVar.f7556t = obtainStyledAttributes2.getBoolean(4, gVar.f7543f);
                            gVar.f7557u = obtainStyledAttributes2.getBoolean(1, gVar.g);
                            gVar.f7558v = obtainStyledAttributes2.getInt(21, -1);
                            gVar.f7561y = obtainStyledAttributes2.getString(12);
                            gVar.f7559w = obtainStyledAttributes2.getResourceId(13, 0);
                            gVar.f7560x = obtainStyledAttributes2.getString(15);
                            String string3 = obtainStyledAttributes2.getString(14);
                            boolean z12 = string3 != null;
                            if (z12 && gVar.f7559w == 0 && gVar.f7560x == null) {
                                gVar.f7562z = (o) gVar.a(string3, f7564f, this.f7566b);
                            } else {
                                if (z12) {
                                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                }
                                gVar.f7562z = null;
                            }
                            gVar.A = obtainStyledAttributes2.getText(17);
                            gVar.B = obtainStyledAttributes2.getText(22);
                            if (obtainStyledAttributes2.hasValue(19)) {
                                gVar.D = i1.c(obtainStyledAttributes2.getInt(19, -1), gVar.D);
                            } else {
                                gVar.D = null;
                            }
                            if (obtainStyledAttributes2.hasValue(18)) {
                                if (!obtainStyledAttributes2.hasValue(18) || (resourceId = obtainStyledAttributes2.getResourceId(18, 0)) == 0 || (colorStateList = n4.a.n(context, resourceId)) == null) {
                                    colorStateList = obtainStyledAttributes2.getColorStateList(18);
                                }
                                gVar.C = colorStateList;
                            } else {
                                gVar.C = null;
                            }
                            obtainStyledAttributes2.recycle();
                            gVar.f7544h = false;
                            xmlPullParser2 = xmlPullParser;
                        } else if (name3.equals("menu")) {
                            gVar.f7544h = true;
                            SubMenu addSubMenu = gVar.f7538a.addSubMenu(gVar.f7539b, gVar.f7545i, gVar.f7546j, gVar.f7547k);
                            gVar.b(addSubMenu.getItem());
                            xmlPullParser2 = xmlPullParser;
                            b(xmlPullParser2, attributeSet, addSubMenu);
                        } else {
                            xmlPullParser2 = xmlPullParser;
                            str = name3;
                            z11 = true;
                        }
                        eventType = xmlPullParser2.next();
                        i10 = 2;
                        z10 = z10;
                        z11 = z11;
                    }
                }
                xmlPullParser2 = xmlPullParser;
                z10 = z10;
            }
            eventType = xmlPullParser2.next();
            i10 = 2;
            z10 = z10;
            z11 = z11;
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i10, Menu menu) {
        if (!(menu instanceof l.l)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        boolean z10 = false;
        try {
            try {
                xmlResourceParser = this.f7567c.getResources().getLayout(i10);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
                if (menu instanceof l.l) {
                    l.l lVar = (l.l) menu;
                    if (!lVar.f8002p) {
                        lVar.w();
                        z10 = true;
                    }
                }
                b(xmlResourceParser, asAttributeSet, menu);
                if (z10) {
                    ((l.l) menu).v();
                }
                xmlResourceParser.close();
            } catch (IOException e7) {
                throw new InflateException("Error inflating menu XML", e7);
            } catch (XmlPullParserException e8) {
                throw new InflateException("Error inflating menu XML", e8);
            }
        } catch (Throwable th) {
            if (z10) {
                ((l.l) menu).v();
            }
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
