
!function(t,e){"object"==typeof exports&&"undefined"!=typeof module?module.exports=e():"function"==typeof define&&define.amd?define(e):t.lozad=e()}(this,function(){"use strict";
var g="undefined"!=typeof document&&document.documentMode,f={rootMargin:"0px",threshold:0,load:function(t){if("picture"===t.nodeName.toLowerCase()){var e=t.querySelector("img"),r=!1;null===e&&(e=document.createElement("img"),r=!0),g&&t.getAttribute("data-iesrc")&&(e.src=t.getAttribute("data-iesrc")),t.getAttribute("data-alt")&&(e.alt=t.getAttribute("data-alt")),r&&t.append(e)}if("video"===t.nodeName.toLowerCase()&&!t.getAttribute("data-src")&&t.children){for(var a=t.children,o=void 0,i=0;i<=a.length-1;i++)(o=a[i].getAttribute("data-src"))&&(a[i].src=o);t.load()}t.getAttribute("data-poster")&&(t.poster=t.getAttribute("data-poster")),t.getAttribute("data-src")&&(t.src=t.getAttribute("data-src")),t.getAttribute("data-srcset")&&t.setAttribute("srcset",t.getAttribute("data-srcset"));var n=",";if(t.getAttribute("data-background-delimiter")&&(n=t.getAttribute("data-background-delimiter")),t.getAttribute("data-background-image"))t.style.backgroundImage="url('"+t.getAttribute("data-background-image").split(n).join("'),url('")+"')";else if(t.getAttribute("data-background-image-set")){var d=t.getAttribute("data-background-image-set").split(n),u=d[0].substr(0,d[0].indexOf(" "))||d[0];
u=-1===u.indexOf("url(")?"url("+u+")":u,1===d.length?t.style.backgroundImage=u:t.setAttribute("style",(t.getAttribute("style")||"")+"background-image: "+u+"; background-image: -webkit-image-set("+d+"); background-image: image-set("+d+")")}t.getAttribute("data-toggle-class")&&t.classList.toggle(t.getAttribute("data-toggle-class"))},loaded:function(){}};function A(t){t.setAttribute("data-loaded",!0)}var m=function(t){return"true"===t.getAttribute("data-loaded")},v=function(t){var e=1<arguments.length&&void 0!==arguments[1]?arguments[1]:document;return t instanceof Element?[t]:t instanceof NodeList?t:e.querySelectorAll(t)};return function(){var r,a,o=0<arguments.length&&void 0!==arguments[0]?arguments[0]:".lozad",t=1<arguments.length&&void 0!==arguments[1]?arguments[1]:{},e=Object.assign({},f,t),i=e.root,n=e.rootMargin,d=e.threshold,u=e.load,g=e.loaded,s=void 0;"undefined"!=typeof window&&window.IntersectionObserver&&(s=new IntersectionObserver((r=u,a=g,function(t,e){t.forEach(function(t){(0<t.intersectionRatio||t.isIntersecting)&&(e.unobserve(t.target),m(t.target)||(r(t.target),A(t.target),a(t.target)))})}),{root:i,rootMargin:n,threshold:d}));for(var c,l=v(o,i),b=0;b<l.length;b++)(c=l[b]).getAttribute("data-placeholder-background")&&(c.style.background=c.getAttribute("data-placeholder-background"));return{observe:function(){for(var t=v(o,i),e=0;e<t.length;e++)m(t[e])||(s?s.observe(t[e]):(u(t[e]),A(t[e]),g(t[e])))},triggerLoad:function(t){m(t)||(u(t),A(t),g(t))},observer:s}}});


const observer = lozad(); 
observer.observe();


const test = lozad('.lazy', {
    loaded: function (el) {
        var allElements = el.querySelectorAll("source")
        for (x of allElements) {
            x.setAttribute("srcset", x.getAttribute("data-srcset"));
        }
    }
});
test.observe();