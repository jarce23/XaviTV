package x2;

import com.bumptech.glide.d;
import i1.f0;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f13490f = Pattern.compile("(.+?)='(.*?)';", 32);

    /* renamed from: d, reason: collision with root package name */
    public final CharsetDecoder f13491d = StandardCharsets.UTF_8.newDecoder();

    /* renamed from: e, reason: collision with root package name */
    public final CharsetDecoder f13492e = StandardCharsets.ISO_8859_1.newDecoder();

    @Override // com.bumptech.glide.d
    public final f0 j(t2.a aVar, ByteBuffer byteBuffer) {
        String str;
        CharsetDecoder charsetDecoder = this.f13492e;
        CharsetDecoder charsetDecoder2 = this.f13491d;
        String str2 = null;
        try {
            str = charsetDecoder2.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                String charBuffer = charsetDecoder.decode(byteBuffer).toString();
                charsetDecoder.reset();
                byteBuffer.rewind();
                str = charBuffer;
            } catch (CharacterCodingException unused2) {
                charsetDecoder.reset();
                byteBuffer.rewind();
                str = null;
            } catch (Throwable th) {
                charsetDecoder.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            charsetDecoder2.reset();
            byteBuffer.rewind();
        }
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        if (str == null) {
            return new f0(new c(null, null, bArr));
        }
        Matcher matcher = f13490f.matcher(str);
        String str3 = null;
        for (int i10 = 0; matcher.find(i10); i10 = matcher.end()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            if (group != null) {
                String C = com.bumptech.glide.c.C(group);
                C.getClass();
                if (C.equals("streamurl")) {
                    str3 = group2;
                } else if (C.equals("streamtitle")) {
                    str2 = group2;
                }
            }
        }
        return new f0(new c(str2, str3, bArr));
    }
}
