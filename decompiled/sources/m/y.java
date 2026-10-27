package m;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class y {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f8598d = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8599a = 2;

    /* renamed from: b, reason: collision with root package name */
    public View f8600b;

    /* renamed from: c, reason: collision with root package name */
    public Object f8601c;

    public /* synthetic */ y() {
    }

    public KeyListener a(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((x4.e) ((p4.p) this.f8601c).f9953p).getClass();
        if (keyListener instanceof v0.e) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new v0.e(keyListener);
    }

    public void b(AttributeSet attributeSet, int i10) {
        switch (this.f8599a) {
            case 0:
                AbsSeekBar absSeekBar = (AbsSeekBar) this.f8600b;
                android.support.v4.media.session.a0 T = android.support.v4.media.session.a0.T(absSeekBar.getContext(), attributeSet, f8598d, i10);
                Drawable L = T.L(0);
                if (L != null) {
                    if (L instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) L;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i11 = 0; i11 < numberOfFrames; i11++) {
                            Drawable e7 = e(animationDrawable.getFrame(i11), true);
                            e7.setLevel(10000);
                            animationDrawable2.addFrame(e7, animationDrawable.getDuration(i11));
                        }
                        animationDrawable2.setLevel(10000);
                        L = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(L);
                }
                Drawable L2 = T.L(1);
                if (L2 != null) {
                    absSeekBar.setProgressDrawable(e(L2, false));
                }
                T.U();
                return;
            default:
                TypedArray obtainStyledAttributes = ((EditText) this.f8600b).getContext().obtainStyledAttributes(attributeSet, e.a.f4365i, i10, 0);
                try {
                    boolean z10 = obtainStyledAttributes.hasValue(14) ? obtainStyledAttributes.getBoolean(14, true) : true;
                    obtainStyledAttributes.recycle();
                    d(z10);
                    return;
                } catch (Throwable th) {
                    obtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    public v0.b c(InputConnection inputConnection, EditorInfo editorInfo) {
        p4.p pVar = (p4.p) this.f8601c;
        if (inputConnection == null) {
            pVar.getClass();
            inputConnection = null;
        } else {
            x4.e eVar = (x4.e) pVar.f9953p;
            eVar.getClass();
            if (!(inputConnection instanceof v0.b)) {
                inputConnection = new v0.b((EditText) eVar.f13542p, inputConnection, editorInfo);
            }
        }
        return (v0.b) inputConnection;
    }

    public void d(boolean z10) {
        v0.h hVar = (v0.h) ((x4.e) ((p4.p) this.f8601c).f9953p).f13543q;
        if (hVar.f12648q != z10) {
            if (hVar.f12647p != null) {
                androidx.emoji2.text.l a10 = androidx.emoji2.text.l.a();
                m2 m2Var = hVar.f12647p;
                a10.getClass();
                y7.d.d("initCallback cannot be null", m2Var);
                ReentrantReadWriteLock reentrantReadWriteLock = a10.f577a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    a10.f578b.remove(m2Var);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            hVar.f12648q = z10;
            if (z10) {
                v0.h.a(hVar.f12646o, androidx.emoji2.text.l.a().b());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable e(Drawable drawable, boolean z10) {
        if (drawable instanceof f0.a) {
            ((f0.b) ((f0.a) drawable)).getClass();
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i10 = 0; i10 < numberOfLayers; i10++) {
                    int id = layerDrawable.getId(i10);
                    drawableArr[i10] = e(layerDrawable.getDrawable(i10), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i11 = 0; i11 < numberOfLayers; i11++) {
                    layerDrawable2.setId(i11, layerDrawable.getId(i11));
                    layerDrawable2.setLayerGravity(i11, layerDrawable.getLayerGravity(i11));
                    layerDrawable2.setLayerWidth(i11, layerDrawable.getLayerWidth(i11));
                    layerDrawable2.setLayerHeight(i11, layerDrawable.getLayerHeight(i11));
                    layerDrawable2.setLayerInsetLeft(i11, layerDrawable.getLayerInsetLeft(i11));
                    layerDrawable2.setLayerInsetRight(i11, layerDrawable.getLayerInsetRight(i11));
                    layerDrawable2.setLayerInsetTop(i11, layerDrawable.getLayerInsetTop(i11));
                    layerDrawable2.setLayerInsetBottom(i11, layerDrawable.getLayerInsetBottom(i11));
                    layerDrawable2.setLayerInsetStart(i11, layerDrawable.getLayerInsetStart(i11));
                    layerDrawable2.setLayerInsetEnd(i11, layerDrawable.getLayerInsetEnd(i11));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (((Bitmap) this.f8601c) == null) {
                    this.f8601c = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z10 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    public y(AbsSeekBar absSeekBar) {
        this.f8600b = absSeekBar;
    }

    public y(EditText editText) {
        this.f8600b = editText;
        this.f8601c = new p4.p(editText);
    }
}
