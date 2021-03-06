var VERSION = 'v1';
var urlsToCache =[
    '/index.html',
    './jquery-3.3.1.min.js',
    '/image/bg.jpg'
];

// 监听 install 安装 事件  在 install时 缓存数据
self.addEventListener('install', function(event) {
    // 这里的waitUtil会在安装成功之前执行一些预装的操作，但是只建议做一些轻量级和非常重要资源的缓存，减少安装失败的概率。
    // 安装成功  后ServiceWorker状态会从installing变为installed
    event.waitUntil(
        caches.open(VERSION).then(function(cache) {
            return cache.addAll(urlsToCache);
        })
    );
});

// 监听 activate 事件  在 activate 时 缓存更新数据
self.addEventListener('activate', function(event) {
    event.waitUntil(
        caches.keys().then(function(cacheNames) {
            return Promise.all(
                cacheNames.map(function(cacheName) {
                    // 如果当前版本和缓存版本不一致
                    if (cacheName !== VERSION) {
                        return caches.delete(cacheName);
                    }
                })
            );
        })
    );
});

//页面和ServiceWorker质检可以通过postMessage方法发送消息，发送的消息可以通过message事件接收到  可以实现消息推送
self.addEventListener('push', function(event) {
    alert("push message");
    var title = 'Yay a message.';
    var body = 'We have received a push message.';
    var icon = '/images/icon-192x192.png';
    var tag = 'simple-push-demo-notification-tag';
    var data = {
        doge: {
            wow: 'such amaze notification data'
        }
    };
    //该方法是用来延迟 SW 的结束。因为，SW 可能在任何时间结束，为了防止这样的情况，需要使用 waitUntil 监听 promise，使系统不会在 promise 执行时就结束 SW
    event.waitUntil(
        //该方法执行后，会发回一个 promise 对象。
        self.registration.showNotification(title, {
            body: body,
            icon: icon,
            tag: tag,
            data: data
        })
    );
});



// 捕获请求并返回缓存数据
// 在页面发起http/https请求时，Service Worker可以通过fetch事件拦截请求，并且给出自己的相应缓存数据
self.addEventListener('fetch', function(event) {
    event.respondWith(caches.match(event.request).catch(function() {
        return fetch(event.request);
    }).then(function(response) {
        caches.open(VERSION).then(function(cache) {
            cache.put(event.request, response);
        });
        return response.clone();
    }).catch(function() {
        return caches.match('/image/bg.jpg');
    }));
});