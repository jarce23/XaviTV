package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.List;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class AggregateEventListener extends EventListener {
        private final EventListener[] eventListeners;

        public AggregateEventListener(EventListener[] eventListenerArr) {
            h.e("eventListeners", eventListenerArr);
            this.eventListeners = eventListenerArr;
        }

        @Override // okhttp3.EventListener
        public void cacheConditionalHit(Call call, Response response) {
            h.e("call", call);
            h.e("cachedResponse", response);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.cacheConditionalHit(call, response);
            }
        }

        @Override // okhttp3.EventListener
        public void cacheHit(Call call, Response response) {
            h.e("call", call);
            h.e("response", response);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.cacheHit(call, response);
            }
        }

        @Override // okhttp3.EventListener
        public void cacheMiss(Call call) {
            h.e("call", call);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.cacheMiss(call);
            }
        }

        @Override // okhttp3.EventListener
        public void callEnd(Call call) {
            h.e("call", call);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.callEnd(call);
            }
        }

        @Override // okhttp3.EventListener
        public void callFailed(Call call, IOException iOException) {
            h.e("call", call);
            h.e("ioe", iOException);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.callFailed(call, iOException);
            }
        }

        @Override // okhttp3.EventListener
        public void callStart(Call call) {
            h.e("call", call);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.callStart(call);
            }
        }

        @Override // okhttp3.EventListener
        public void canceled(Call call) {
            h.e("call", call);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.canceled(call);
            }
        }

        @Override // okhttp3.EventListener
        public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
            h.e("call", call);
            h.e("inetSocketAddress", inetSocketAddress);
            h.e("proxy", proxy);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectEnd(call, inetSocketAddress, proxy, protocol);
            }
        }

        @Override // okhttp3.EventListener
        public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
            h.e("call", call);
            h.e("inetSocketAddress", inetSocketAddress);
            h.e("proxy", proxy);
            h.e("ioe", iOException);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
            }
        }

        @Override // okhttp3.EventListener
        public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            h.e("call", call);
            h.e("inetSocketAddress", inetSocketAddress);
            h.e("proxy", proxy);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectStart(call, inetSocketAddress, proxy);
            }
        }

        @Override // okhttp3.EventListener
        public void connectionAcquired(Call call, Connection connection) {
            h.e("call", call);
            h.e("connection", connection);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectionAcquired(call, connection);
            }
        }

        @Override // okhttp3.EventListener
        public void connectionReleased(Call call, Connection connection) {
            h.e("call", call);
            h.e("connection", connection);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectionReleased(call, connection);
            }
        }

        @Override // okhttp3.EventListener
        public void dispatcherQueueEnd(Call call, Dispatcher dispatcher) {
            h.e("call", call);
            h.e("dispatcher", dispatcher);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.dispatcherQueueEnd(call, dispatcher);
            }
        }

        @Override // okhttp3.EventListener
        public void dispatcherQueueStart(Call call, Dispatcher dispatcher) {
            h.e("call", call);
            h.e("dispatcher", dispatcher);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.dispatcherQueueStart(call, dispatcher);
            }
        }

        @Override // okhttp3.EventListener
        public void dnsEnd(Call call, String str, List<InetAddress> list) {
            h.e("call", call);
            h.e("domainName", str);
            h.e("inetAddressList", list);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.dnsEnd(call, str, list);
            }
        }

        @Override // okhttp3.EventListener
        public void dnsStart(Call call, String str) {
            h.e("call", call);
            h.e("domainName", str);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.dnsStart(call, str);
            }
        }

        @Override // okhttp3.EventListener
        public void followUpDecision(Call call, Response response, Request request) {
            h.e("call", call);
            h.e("networkResponse", response);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.followUpDecision(call, response, request);
            }
        }

        public final EventListener[] getEventListeners() {
            return this.eventListeners;
        }

        @Override // okhttp3.EventListener
        public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
            h.e("call", call);
            h.e("url", httpUrl);
            h.e("proxies", list);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.proxySelectEnd(call, httpUrl, list);
            }
        }

        @Override // okhttp3.EventListener
        public void proxySelectStart(Call call, HttpUrl httpUrl) {
            h.e("call", call);
            h.e("url", httpUrl);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.proxySelectStart(call, httpUrl);
            }
        }

        @Override // okhttp3.EventListener
        public void requestBodyEnd(Call call, long j10) {
            h.e("call", call);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestBodyEnd(call, j10);
            }
        }

        @Override // okhttp3.EventListener
        public void requestBodyStart(Call call) {
            h.e("call", call);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestBodyStart(call);
            }
        }

        @Override // okhttp3.EventListener
        public void requestFailed(Call call, IOException iOException) {
            h.e("call", call);
            h.e("ioe", iOException);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestFailed(call, iOException);
            }
        }

        @Override // okhttp3.EventListener
        public void requestHeadersEnd(Call call, Request request) {
            h.e("call", call);
            h.e("request", request);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestHeadersEnd(call, request);
            }
        }

        @Override // okhttp3.EventListener
        public void requestHeadersStart(Call call) {
            h.e("call", call);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestHeadersStart(call);
            }
        }

        @Override // okhttp3.EventListener
        public void responseBodyEnd(Call call, long j10) {
            h.e("call", call);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseBodyEnd(call, j10);
            }
        }

        @Override // okhttp3.EventListener
        public void responseBodyStart(Call call) {
            h.e("call", call);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseBodyStart(call);
            }
        }

        @Override // okhttp3.EventListener
        public void responseFailed(Call call, IOException iOException) {
            h.e("call", call);
            h.e("ioe", iOException);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseFailed(call, iOException);
            }
        }

        @Override // okhttp3.EventListener
        public void responseHeadersEnd(Call call, Response response) {
            h.e("call", call);
            h.e("response", response);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseHeadersEnd(call, response);
            }
        }

        @Override // okhttp3.EventListener
        public void responseHeadersStart(Call call) {
            h.e("call", call);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseHeadersStart(call);
            }
        }

        @Override // okhttp3.EventListener
        public void retryDecision(Call call, IOException iOException, boolean z10) {
            h.e("call", call);
            h.e("exception", iOException);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.retryDecision(call, iOException, z10);
            }
        }

        @Override // okhttp3.EventListener
        public void satisfactionFailure(Call call, Response response) {
            h.e("call", call);
            h.e("response", response);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.satisfactionFailure(call, response);
            }
        }

        @Override // okhttp3.EventListener
        public void secureConnectEnd(Call call, Handshake handshake) {
            h.e("call", call);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.secureConnectEnd(call, handshake);
            }
        }

        @Override // okhttp3.EventListener
        public void secureConnectStart(Call call) {
            h.e("call", call);
            for (EventListener eventListener : this.eventListeners) {
                eventListener.secureConnectStart(call);
            }
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public interface Factory {
        EventListener create(Call call);
    }

    public void cacheConditionalHit(Call call, Response response) {
        h.e("call", call);
        h.e("cachedResponse", response);
    }

    public void cacheHit(Call call, Response response) {
        h.e("call", call);
        h.e("response", response);
    }

    public void cacheMiss(Call call) {
        h.e("call", call);
    }

    public void callEnd(Call call) {
        h.e("call", call);
    }

    public void callFailed(Call call, IOException iOException) {
        h.e("call", call);
        h.e("ioe", iOException);
    }

    public void callStart(Call call) {
        h.e("call", call);
    }

    public void canceled(Call call) {
        h.e("call", call);
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        h.e("call", call);
        h.e("inetSocketAddress", inetSocketAddress);
        h.e("proxy", proxy);
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        h.e("call", call);
        h.e("inetSocketAddress", inetSocketAddress);
        h.e("proxy", proxy);
        h.e("ioe", iOException);
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        h.e("call", call);
        h.e("inetSocketAddress", inetSocketAddress);
        h.e("proxy", proxy);
    }

    public void connectionAcquired(Call call, Connection connection) {
        h.e("call", call);
        h.e("connection", connection);
    }

    public void connectionReleased(Call call, Connection connection) {
        h.e("call", call);
        h.e("connection", connection);
    }

    public void dispatcherQueueEnd(Call call, Dispatcher dispatcher) {
        h.e("call", call);
        h.e("dispatcher", dispatcher);
    }

    public void dispatcherQueueStart(Call call, Dispatcher dispatcher) {
        h.e("call", call);
        h.e("dispatcher", dispatcher);
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        h.e("call", call);
        h.e("domainName", str);
        h.e("inetAddressList", list);
    }

    public void dnsStart(Call call, String str) {
        h.e("call", call);
        h.e("domainName", str);
    }

    public void followUpDecision(Call call, Response response, Request request) {
        h.e("call", call);
        h.e("networkResponse", response);
    }

    public final EventListener plus(EventListener eventListener) {
        h.e("other", eventListener);
        EventListener eventListener2 = NONE;
        if (this == eventListener2) {
            return eventListener;
        }
        EventListener[] eventListeners = this instanceof AggregateEventListener ? ((AggregateEventListener) this).getEventListeners() : new EventListener[]{this};
        if (eventListener == eventListener2) {
            return this;
        }
        EventListener[] eventListeners2 = eventListener instanceof AggregateEventListener ? ((AggregateEventListener) eventListener).getEventListeners() : new EventListener[]{eventListener};
        h.e("<this>", eventListeners);
        h.e("elements", eventListeners2);
        int length = eventListeners.length;
        int length2 = eventListeners2.length;
        Object[] copyOf = Arrays.copyOf(eventListeners, length + length2);
        System.arraycopy(eventListeners2, 0, copyOf, length, length2);
        h.b(copyOf);
        return new AggregateEventListener((EventListener[]) copyOf);
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
        h.e("call", call);
        h.e("url", httpUrl);
        h.e("proxies", list);
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        h.e("call", call);
        h.e("url", httpUrl);
    }

    public void requestBodyEnd(Call call, long j10) {
        h.e("call", call);
    }

    public void requestBodyStart(Call call) {
        h.e("call", call);
    }

    public void requestFailed(Call call, IOException iOException) {
        h.e("call", call);
        h.e("ioe", iOException);
    }

    public void requestHeadersEnd(Call call, Request request) {
        h.e("call", call);
        h.e("request", request);
    }

    public void requestHeadersStart(Call call) {
        h.e("call", call);
    }

    public void responseBodyEnd(Call call, long j10) {
        h.e("call", call);
    }

    public void responseBodyStart(Call call) {
        h.e("call", call);
    }

    public void responseFailed(Call call, IOException iOException) {
        h.e("call", call);
        h.e("ioe", iOException);
    }

    public void responseHeadersEnd(Call call, Response response) {
        h.e("call", call);
        h.e("response", response);
    }

    public void responseHeadersStart(Call call) {
        h.e("call", call);
    }

    public void retryDecision(Call call, IOException iOException, boolean z10) {
        h.e("call", call);
        h.e("exception", iOException);
    }

    public void satisfactionFailure(Call call, Response response) {
        h.e("call", call);
        h.e("response", response);
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        h.e("call", call);
    }

    public void secureConnectStart(Call call) {
        h.e("call", call);
    }
}
