/*!
    * Start Bootstrap - SB Admin v7.0.7 (https://startbootstrap.com/template/sb-admin)
    * Copyright 2013-2023 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
    */
// 
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

});

addEventListener('message', function (event) {
    if (event.data && event.data.extensionMessage) {
        alert(event.data.extensionMessage);
    }
});

chrome.runtime.onMessage.addListener((message, sender, sendResponse) => {
    chrome.storage.local.set({ foo: 'bar' }, () => {
        sendResponse('whatever');
    });
    return true;
});


chrome.runtime.onMessage.addListener((message, sender, sendResponse) => {
    fetch(message.url).then(r => r.text())
        .then(t => sendResponse({ ok: t }))
        .catch(e => sendResponse({ err: e.message }));
    return true;
});