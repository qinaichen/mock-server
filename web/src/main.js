import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
import VueCodemirror from 'vue-codemirror'
import 'codemirror/lib/codemirror.css'
// 支持javascirpt语言
import 'codemirror/mode/javascript/javascript.js'
//主题 monokai
import 'codemirror/theme/monokai.css'

import 'codemirror/addon/hint/show-hint.css';
import 'codemirror/addon/hint/show-hint.js';
import 'codemirror/addon/hint/anyword-hint.js';
import 'codemirror/addon/hint/javascript-hint.js';
//
import 'codemirror/addon/fold/foldgutter.css'
import "codemirror/addon/fold/foldcode.js"
import "codemirror/addon/fold/foldgutter.js"
import "codemirror/addon/fold/brace-fold.js"
import "codemirror/addon/fold/comment-fold.js"
import 'codemirror/addon/display/fullscreen.css'
import 'codemirror/addon/display/fullscreen.js'
import 'codemirror/addon/edit/closebrackets.js'
import 'codemirror/addon/lint/lint.css'
import 'codemirror/addon/lint/lint.js'
import 'codemirror/addon/lint/json-lint.js'
import axios from 'axios'
import App from './App'
import router from './router'

Vue.config.productionTip = false

Vue.use(ElementUI,{size:'small'});
Vue.use(VueCodemirror)
Vue.prototype.$axios = axios;

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
