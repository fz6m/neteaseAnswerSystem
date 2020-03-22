import Vue from 'vue'
import App from './App'

import Vuex from 'vuex';
Vue.use(Vuex);

import vusLayerInit from './components/vusui-app-layer/vusui-layer.js';
import vusLayer from './components/vusui-app-layer/vusui-layer.vue';
Vue.use(vusLayerInit);
Vue.component('vus-layer', vusLayer); //设置组件名称

Vue.config.productionTip = false
App.mpType = 'app'

const store = new Vuex.Store();
const app = new Vue({
    store,
    ...App
})
app.$mount()