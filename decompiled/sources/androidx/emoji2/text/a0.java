package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ReplacementSpan;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 extends ReplacementSpan {

    /* renamed from: p, reason: collision with root package name */
    public final z f557p;

    /* renamed from: s, reason: collision with root package name */
    public TextPaint f560s;

    /* renamed from: o, reason: collision with root package name */
    public final Paint.FontMetricsInt f556o = new Paint.FontMetricsInt();

    /* renamed from: q, reason: collision with root package name */
    public short f558q = -1;

    /* renamed from: r, reason: collision with root package name */
    public float f559r = 1.0f;

    public a0(z zVar) {
        y7.d.d("rasterizer cannot be null", zVar);
        this.f557p = zVar;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        TextPaint textPaint = null;
        if (charSequence instanceof Spanned) {
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i10, i11, CharacterStyle.class);
            if (characterStyleArr.length != 0) {
                if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                    TextPaint textPaint2 = this.f560s;
                    if (textPaint2 == null) {
                        textPaint2 = new TextPaint();
                        this.f560s = textPaint2;
                    }
                    textPaint = textPaint2;
                    textPaint.set(paint);
                    for (CharacterStyle characterStyle : characterStyleArr) {
                        characterStyle.updateDrawState(textPaint);
                    }
                }
            }
            if (paint instanceof TextPaint) {
                textPaint = (TextPaint) paint;
            }
        } else if (paint instanceof TextPaint) {
            textPaint = (TextPaint) paint;
        }
        TextPaint textPaint3 = textPaint;
        if (textPaint3 != null && textPaint3.bgColor != 0) {
            int color = textPaint3.getColor();
            Paint.Style style = textPaint3.getStyle();
            textPaint3.setColor(textPaint3.bgColor);
            textPaint3.setStyle(Paint.Style.FILL);
            canvas.drawRect(f10, i12, f10 + this.f558q, i14, textPaint3);
            textPaint3.setStyle(style);
            textPaint3.setColor(color);
        }
        l.a().getClass();
        float f11 = i13;
        Paint paint2 = textPaint3;
        if (textPaint3 == null) {
            paint2 = paint;
        }
        z zVar = this.f557p;
        x4.i iVar = zVar.f619b;
        Typeface typeface = (Typeface) iVar.f13556s;
        Typeface typeface2 = paint2.getTypeface();
        paint2.setTypeface(typeface);
        canvas.drawText((char[]) iVar.f13554q, zVar.f618a * 2, 2, f10, f11, paint2);
        paint2.setTypeface(typeface2);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f556o;
        paint.getFontMetricsInt(fontMetricsInt2);
        float abs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        z zVar = this.f557p;
        this.f559r = abs / (zVar.b().a(14) != 0 ? ((ByteBuffer) r8.f8748r).getShort(r1 + r8.f8745o) : (short) 0);
        u0.a b2 = zVar.b();
        int a10 = b2.a(14);
        if (a10 != 0) {
            ((ByteBuffer) b2.f8748r).getShort(a10 + b2.f8745o);
        }
        short s10 = (short) ((zVar.b().a(12) != 0 ? ((ByteBuffer) r5.f8748r).getShort(r7 + r5.f8745o) : (short) 0) * this.f559r);
        this.f558q = s10;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s10;
    }
}
