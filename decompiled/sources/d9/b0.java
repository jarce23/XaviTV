package d9;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import java.util.Objects;
import org.chromium.net.R;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f4243a;

    /* renamed from: b, reason: collision with root package name */
    public final n f4244b;

    /* renamed from: c, reason: collision with root package name */
    public final int[][] f4245c;

    /* renamed from: d, reason: collision with root package name */
    public final n[] f4246d;

    /* renamed from: e, reason: collision with root package name */
    public final z f4247e;

    /* renamed from: f, reason: collision with root package name */
    public final z f4248f;
    public final z g;

    /* renamed from: h, reason: collision with root package name */
    public final z f4249h;

    public b0(a0 a0Var) {
        this.f4243a = a0Var.f4234a;
        this.f4244b = a0Var.f4235b;
        this.f4245c = a0Var.f4236c;
        this.f4246d = a0Var.f4237d;
        this.f4247e = a0Var.f4238e;
        this.f4248f = a0Var.f4239f;
        this.g = a0Var.g;
        this.f4249h = a0Var.f4240h;
    }

    public static void a(a0 a0Var, Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlResourceParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth && xmlResourceParser.getName().equals("item")) {
                Resources resources = context.getResources();
                int[] iArr = j8.a.f7197r;
                TypedArray obtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                n a10 = n.a(context, obtainAttributes.getResourceId(0, 0), obtainAttributes.getResourceId(1, 0), new a(0)).a();
                obtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i10 = 0;
                for (int i11 = 0; i11 < attributeCount; i11++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i11);
                    if (attributeNameResource != R.attr.shapeAppearance && attributeNameResource != R.attr.shapeAppearanceOverlay) {
                        int i12 = i10 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i11, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i10] = attributeNameResource;
                        i10 = i12;
                    }
                }
                a0Var.a(StateSet.trimStateSet(iArr2, i10), a10);
            }
        }
    }

    public static b0 b(Context context, TypedArray typedArray, int i10) {
        XmlResourceParser xml;
        int next;
        int resourceId = typedArray.getResourceId(i10, 0);
        if (resourceId == 0 || !Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return null;
        }
        a0 a0Var = new a0();
        a0Var.b();
        try {
            xml = context.getResources().getXml(resourceId);
        } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
            a0Var.b();
        }
        try {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            if (xml.getName().equals("selector")) {
                a(a0Var, context, xml, asAttributeSet, context.getTheme());
            }
            xml.close();
            if (a0Var.f4234a == 0) {
                return null;
            }
            return new b0(a0Var);
        } catch (Throwable th) {
            if (xml != null) {
                try {
                    xml.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final n c() {
        n nVar = this.f4244b;
        z zVar = this.f4249h;
        z zVar2 = this.g;
        z zVar3 = this.f4248f;
        z zVar4 = this.f4247e;
        if (zVar4 == null && zVar3 == null && zVar2 == null && zVar == null) {
            return nVar;
        }
        m f10 = nVar.f();
        if (zVar4 != null) {
            f10.f4293e = zVar4.f4347b;
        }
        if (zVar3 != null) {
            f10.f4294f = zVar3.f4347b;
        }
        if (zVar2 != null) {
            f10.f4295h = zVar2.f4347b;
        }
        if (zVar != null) {
            f10.g = zVar.f4347b;
        }
        return f10.a();
    }

    public final boolean d() {
        z zVar;
        z zVar2;
        z zVar3;
        z zVar4;
        return this.f4243a > 1 || ((zVar = this.f4247e) != null && zVar.f4346a > 1) || (((zVar2 = this.f4248f) != null && zVar2.f4346a > 1) || (((zVar3 = this.g) != null && zVar3.f4346a > 1) || ((zVar4 = this.f4249h) != null && zVar4.f4346a > 1)));
    }
}
