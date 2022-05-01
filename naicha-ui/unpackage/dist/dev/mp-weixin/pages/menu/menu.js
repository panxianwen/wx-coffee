(global["webpackJsonp"] = global["webpackJsonp"] || []).push([["pages/menu/menu"],{

/***/ 24:
/*!***************************************************************************************************!*\
  !*** /Users/panxianwen/Code/wx-applet/wx-naicha/naicha-ui/main.js?{"page":"pages%2Fmenu%2Fmenu"} ***!
  \***************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function(createPage) {__webpack_require__(/*! uni-pages */ 5);
var _vue = _interopRequireDefault(__webpack_require__(/*! vue */ 3));
var _menu = _interopRequireDefault(__webpack_require__(/*! ./pages/menu/menu.vue */ 25));function _interopRequireDefault(obj) {return obj && obj.__esModule ? obj : { default: obj };}wx.__webpack_require_UNI_MP_PLUGIN__ = __webpack_require__;
createPage(_menu.default);
/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./node_modules/@dcloudio/uni-mp-weixin/dist/index.js */ 1)["createPage"]))

/***/ }),

/***/ 25:
/*!********************************************************************************!*\
  !*** /Users/panxianwen/Code/wx-applet/wx-naicha/naicha-ui/pages/menu/menu.vue ***!
  \********************************************************************************/
/*! no static exports found */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _menu_vue_vue_type_template_id_368aef34_scoped_true___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./menu.vue?vue&type=template&id=368aef34&scoped=true& */ 26);
/* harmony import */ var _menu_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./menu.vue?vue&type=script&lang=js& */ 28);
/* harmony reexport (unknown) */ for(var __WEBPACK_IMPORT_KEY__ in _menu_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__) if(__WEBPACK_IMPORT_KEY__ !== 'default') (function(key) { __webpack_require__.d(__webpack_exports__, key, function() { return _menu_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__[key]; }) }(__WEBPACK_IMPORT_KEY__));
/* harmony import */ var _menu_vue_vue_type_style_index_0_id_368aef34_lang_scss_scoped_true___WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./menu.vue?vue&type=style&index=0&id=368aef34&lang=scss&scoped=true& */ 33);
/* harmony import */ var _Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_runtime_componentNormalizer_js__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib/runtime/componentNormalizer.js */ 12);

var renderjs





/* normalize component */

var component = Object(_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_runtime_componentNormalizer_js__WEBPACK_IMPORTED_MODULE_3__["default"])(
  _menu_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__["default"],
  _menu_vue_vue_type_template_id_368aef34_scoped_true___WEBPACK_IMPORTED_MODULE_0__["render"],
  _menu_vue_vue_type_template_id_368aef34_scoped_true___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"],
  false,
  null,
  "368aef34",
  null,
  false,
  _menu_vue_vue_type_template_id_368aef34_scoped_true___WEBPACK_IMPORTED_MODULE_0__["components"],
  renderjs
)

component.options.__file = "pages/menu/menu.vue"
/* harmony default export */ __webpack_exports__["default"] = (component.exports);

/***/ }),

/***/ 26:
/*!***************************************************************************************************************************!*\
  !*** /Users/panxianwen/Code/wx-applet/wx-naicha/naicha-ui/pages/menu/menu.vue?vue&type=template&id=368aef34&scoped=true& ***!
  \***************************************************************************************************************************/
/*! exports provided: render, staticRenderFns, recyclableRender, components */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_16_0_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_template_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_uni_app_loader_page_meta_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_template_id_368aef34_scoped_true___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib/loaders/templateLoader.js??vue-loader-options!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--16-0!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/webpack-uni-mp-loader/lib/template.js!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-uni-app-loader/page-meta.js!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib??vue-loader-options!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/webpack-uni-mp-loader/lib/style.js!./menu.vue?vue&type=template&id=368aef34&scoped=true& */ 27);
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "render", function() { return _Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_16_0_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_template_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_uni_app_loader_page_meta_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_template_id_368aef34_scoped_true___WEBPACK_IMPORTED_MODULE_0__["render"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "staticRenderFns", function() { return _Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_16_0_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_template_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_uni_app_loader_page_meta_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_template_id_368aef34_scoped_true___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "recyclableRender", function() { return _Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_16_0_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_template_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_uni_app_loader_page_meta_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_template_id_368aef34_scoped_true___WEBPACK_IMPORTED_MODULE_0__["recyclableRender"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "components", function() { return _Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_16_0_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_template_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_uni_app_loader_page_meta_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_template_id_368aef34_scoped_true___WEBPACK_IMPORTED_MODULE_0__["components"]; });



/***/ }),

/***/ 27:
/*!***************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib/loaders/templateLoader.js??vue-loader-options!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--16-0!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/template.js!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-uni-app-loader/page-meta.js!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib??vue-loader-options!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/style.js!/Users/panxianwen/Code/wx-applet/wx-naicha/naicha-ui/pages/menu/menu.vue?vue&type=template&id=368aef34&scoped=true& ***!
  \***************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************/
/*! exports provided: render, staticRenderFns, recyclableRender, components */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "render", function() { return render; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "staticRenderFns", function() { return staticRenderFns; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "recyclableRender", function() { return recyclableRender; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "components", function() { return components; });
var components
try {
  components = {
    modal: function() {
      return __webpack_require__.e(/*! import() | components/modal/modal */ "components/modal/modal").then(__webpack_require__.bind(null, /*! @/components/modal/modal.vue */ 104))
    },
    popupLayer: function() {
      return __webpack_require__.e(/*! import() | components/popup-layer/popup-layer */ "components/popup-layer/popup-layer").then(__webpack_require__.bind(null, /*! @/components/popup-layer/popup-layer.vue */ 111))
    }
  }
} catch (e) {
  if (
    e.message.indexOf("Cannot find module") !== -1 &&
    e.message.indexOf(".vue") !== -1
  ) {
    console.error(e.message)
    console.error("1. 排查组件名称拼写是否正确")
    console.error(
      "2. 排查组件是否符合 easycom 规范，文档：https://uniapp.dcloud.net.cn/collocation/pages?id=easycom"
    )
    console.error(
      "3. 若组件不符合 easycom 规范，需手动引入，并在 components 中注册该组件"
    )
  } else {
    throw e
  }
}
var render = function() {
  var _vm = this
  var _h = _vm.$createElement
  var _c = _vm._self._c || _h
  var l0 = _vm.goods
    ? _vm.__map(_vm.goods, function(item, index) {
        var $orig = _vm.__get_orig(item)

        var m0 = _vm.menuCartNum(item.goodsCategoryName)
        var m1 = _vm.menuCartNum(item.goodsCategoryName)
        return {
          $orig: $orig,
          m0: m0,
          m1: m1
        }
      })
    : null
  var l2 = _vm.goods
    ? _vm.__map(_vm.goods, function(category, index) {
        var $orig = _vm.__get_orig(category)

        var l1 = _vm.__map(category.goodsList, function(goods, key) {
          var $orig = _vm.__get_orig(goods)

          var m2 =
            category.goodsCategoryShow &&
            goods.isSell &&
            goods.goodsPropertyVos &&
            goods.goodsPropertyVos.length
              ? _vm.goodsCartNum(goods.id)
              : null
          var m3 =
            category.goodsCategoryShow &&
            goods.isSell &&
            goods.goodsPropertyVos &&
            goods.goodsPropertyVos.length
              ? _vm.goodsCartNum(goods.id)
              : null
          var m4 =
            category.goodsCategoryShow &&
            goods.isSell &&
            !(goods.goodsPropertyVos && goods.goodsPropertyVos.length)
              ? _vm.goodsCartNum(goods.id)
              : null
          var m5 =
            category.goodsCategoryShow &&
            goods.isSell &&
            !(goods.goodsPropertyVos && goods.goodsPropertyVos.length)
              ? _vm.goodsCartNum(goods.id)
              : null
          var m6 =
            category.goodsCategoryShow &&
            goods.isSell &&
            !(goods.goodsPropertyVos && goods.goodsPropertyVos.length)
              ? _vm.goodsCartNum(goods.id)
              : null
          return {
            $orig: $orig,
            m2: m2,
            m3: m3,
            m4: m4,
            m5: m5,
            m6: m6
          }
        })

        return {
          $orig: $orig,
          l1: l1
        }
      })
    : null
  var g0 =
    _vm.goods && _vm.cart && _vm.cart.length && !!_vm.appProperties.shopStatus
      ? new Date().getHours() >= _vm.appProperties.businessStartTime &&
        new Date().getHours() < _vm.appProperties.businessEndTime
      : null
  var m7 = _vm.getGoodSelectedProps(_vm.currentGoods)
  var m8 = m7 ? _vm.getGoodSelectedProps(_vm.currentGoods) : null

  var l3 = _vm.__map(_vm.cart, function(goods, index) {
    var $orig = _vm.__get_orig(goods)

    var m9 = _vm.getGoodSelectedProps(goods)
    return {
      $orig: $orig,
      m9: m9
    }
  })

  if (!_vm._isMounted) {
    _vm.e0 = function($event) {
      _vm.cartPopupVisible = !_vm.cartPopupVisible
    }

    _vm.e1 = function($event) {
      _vm.cartPopupVisible = !_vm.cartPopupVisible
    }
  }

  _vm.$mp.data = Object.assign(
    {},
    {
      $root: {
        l0: l0,
        l2: l2,
        g0: g0,
        m7: m7,
        m8: m8,
        l3: l3
      }
    }
  )
}
var recyclableRender = false
var staticRenderFns = []
render._withStripped = true



/***/ }),

/***/ 28:
/*!*********************************************************************************************************!*\
  !*** /Users/panxianwen/Code/wx-applet/wx-naicha/naicha-ui/pages/menu/menu.vue?vue&type=script&lang=js& ***!
  \*********************************************************************************************************/
/*! no static exports found */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/babel-loader/lib!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--12-1!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/webpack-uni-mp-loader/lib/script.js!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib??vue-loader-options!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/webpack-uni-mp-loader/lib/style.js!./menu.vue?vue&type=script&lang=js& */ 29);
/* harmony import */ var _Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__);
/* harmony reexport (unknown) */ for(var __WEBPACK_IMPORT_KEY__ in _Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__) if(__WEBPACK_IMPORT_KEY__ !== 'default') (function(key) { __webpack_require__.d(__webpack_exports__, key, function() { return _Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__[key]; }) }(__WEBPACK_IMPORT_KEY__));
 /* harmony default export */ __webpack_exports__["default"] = (_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0___default.a); 

/***/ }),

/***/ 29:
/*!****************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/babel-loader/lib!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--12-1!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/script.js!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib??vue-loader-options!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/style.js!/Users/panxianwen/Code/wx-applet/wx-naicha/naicha-ui/pages/menu/menu.vue?vue&type=script&lang=js& ***!
  \****************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function(uni) {Object.defineProperty(exports, "__esModule", { value: true });exports.default = void 0;var _regenerator = _interopRequireDefault(__webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ 30));





































































































































































































































var _vuex = __webpack_require__(/*! vuex */ 9);function _interopRequireDefault(obj) {return obj && obj.__esModule ? obj : { default: obj };}function asyncGeneratorStep(gen, resolve, reject, _next, _throw, key, arg) {try {var info = gen[key](arg);var value = info.value;} catch (error) {reject(error);return;}if (info.done) {resolve(value);} else {Promise.resolve(value).then(_next, _throw);}}function _asyncToGenerator(fn) {return function () {var self = this,args = arguments;return new Promise(function (resolve, reject) {var gen = fn.apply(self, args);function _next(value) {asyncGeneratorStep(gen, resolve, reject, _next, _throw, "next", value);}function _throw(err) {asyncGeneratorStep(gen, resolve, reject, _next, _throw, "throw", err);}_next(undefined);});};}function ownKeys(object, enumerableOnly) {var keys = Object.keys(object);if (Object.getOwnPropertySymbols) {var symbols = Object.getOwnPropertySymbols(object);if (enumerableOnly) symbols = symbols.filter(function (sym) {return Object.getOwnPropertyDescriptor(object, sym).enumerable;});keys.push.apply(keys, symbols);}return keys;}function _objectSpread(target) {for (var i = 1; i < arguments.length; i++) {var source = arguments[i] != null ? arguments[i] : {};if (i % 2) {ownKeys(Object(source), true).forEach(function (key) {_defineProperty(target, key, source[key]);});} else if (Object.getOwnPropertyDescriptors) {Object.defineProperties(target, Object.getOwnPropertyDescriptors(source));} else {ownKeys(Object(source)).forEach(function (key) {Object.defineProperty(target, key, Object.getOwnPropertyDescriptor(source, key));});}}return target;}function _defineProperty(obj, key, value) {if (key in obj) {Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true });} else {obj[key] = value;}return obj;}var modal = function modal() {__webpack_require__.e(/*! require.ensure | components/modal/modal */ "components/modal/modal").then((function () {return resolve(__webpack_require__(/*! @/components/modal/modal */ 104));}).bind(null, __webpack_require__)).catch(__webpack_require__.oe);};var popupLayer = function popupLayer() {__webpack_require__.e(/*! require.ensure | components/popup-layer/popup-layer */ "components/popup-layer/popup-layer").then((function () {return resolve(__webpack_require__(/*! @/components/popup-layer/popup-layer */ 111));}).bind(null, __webpack_require__)).catch(__webpack_require__.oe);};var _default =

{
  components: {
    modal: modal,
    popupLayer: popupLayer },

  data: function data() {
    return {
      goods: [],
      currentCategoryName: '', // 默认分类
      categoryScrollTop: 0,
      menuScrollIntoView: '',
      goodDetailModalVisible: false, //是否饮品详情模态框
      currentGoods: {}, // 当前饮品
      selectedPropertyList: [], // 当前商品的属性
      cartPopupVisible: false,
      sizeCalcState: false,
      // 商品图片的基础路径
      goodsImageBaseUrl: this.$config.env != 'dev' ? 'https://www.panxianwen.com:9001/static/image/' : 'http://localhost:9002/static/image/' };

  },
  onLoad: function onLoad() {
    if (!this.userInfo) {
      // 不登录 通过本地缓存直接进入
      var userInfo = uni.getStorageSync('userInfo');
      if (userInfo) {
        console.log('不登录，走本地缓存');
        this.$store.commit('login', userInfo);
      }
    }
    this.init();
  },
  computed: _objectSpread(_objectSpread({},
  (0, _vuex.mapState)(['userInfo', 'address', 'appProperties', 'takeType', 'cart'])), {}, {
    // 计算单个饮品添加到购物车的数量
    goodsCartNum: function goodsCartNum() {var _this = this;
      return function (id) {return (
          _this.cart.reduce(function (acc, cur) {
            if (cur.id === id) {
              return acc += cur.number;
            }
            return acc;
          }, 0));};
    },
    // 计算该类商品的购买总数
    menuCartNum: function menuCartNum() {var _this2 = this;
      return function (goodsCategoryName) {return (
          _this2.cart.reduce(function (acc, cur) {
            if (cur.goodsCategoryName === goodsCategoryName) {
              return acc += cur.number;
            }
            return acc;
          }, 0));};
    },
    // 计算购物车总数
    getCartGoodsNumber: function getCartGoodsNumber() {
      return this.cart.reduce(function (acc, cur) {return acc + cur.number;}, 0);
    },
    // 计算购物车总价,
    getCartGoodsPrice: function getCartGoodsPrice() {
      var totalPrice = 0;
      this.cart.forEach(function (goods) {
        totalPrice += goods.realPrice * goods.number;
      });
      if (this.$store.getters.getTakeType == '外卖配送') {
        totalPrice += this.appProperties.packingPrice + this.appProperties.sendingPrice;
      }
      return totalPrice;
    }, // 是否达到起送价
    disabledPay: function disabledPay() {
      return this.$store.getters.getTakeType == '外卖配送' && this.getCartGoodsPrice < this.appProperties.sendingNeedLeastPrice ? true : false;
    }, // 差多少元起送
    spread: function spread() {
      if (this.$store.getters.getTakeType != '外卖配送') return;
      return this.appProperties.sendingNeedLeastPrice - this.getCartGoodsPrice;
    } }),

  onPullDownRefresh: function onPullDownRefresh() {
    setTimeout(function () {
      uni.stopPullDownRefresh();
    }, 2000);
    this.init();
  },
  methods: {
    //页面初始化
    init: function init() {var _this3 = this;return _asyncToGenerator( /*#__PURE__*/_regenerator.default.mark(function _callee() {var that;return _regenerator.default.wrap(function _callee$(_context) {while (1) {switch (_context.prev = _context.next) {case 0:
                that = _this3;
                that.$request('/api-system/config', 'get').then(function (result) {
                  console.log('刷新配置信息:' + JSON.stringify(result.data));
                  that.$store.commit('set_app_properties', result.data);
                });

                that.$request('/api-app/goods/goodsMenu/list', 'get').then(function (result) {
                  that.goods = result.data;
                  that.sizeCalcState = false;
                  uni.stopPullDownRefresh();
                });case 3:case "end":return _context.stop();}}}, _callee);}))();
    },
    toLogin: function toLogin() {
      uni.navigateTo({ url: '/pages/login/login' });
    },
    // 选择到店自取的方式下单
    takein: function takein() {
      this.$store.commit('set_take_type', '到店自取');
    },
    // 选择外卖配送的方式下单
    takeout: function takeout() {
      this.$store.commit('set_take_type', '外卖配送');
      if (!this.userInfo) {
        uni.navigateTo({ url: '/pages/login/login' });
        return;
      }
    },
    handleMenuTap: function handleMenuTap(goodsCategoryName) {var _this4 = this;
      if (!this.sizeCalcState) {
        this.calcSize();
      }

      this.currentCategoryName = goodsCategoryName;
      this.$nextTick(function () {return _this4.categoryScrollTop = _this4.goods.find(function (item) {return item.goodsCategoryName == goodsCategoryName;}).top;});
    },
    handleGoodsScroll: function handleGoodsScroll(_ref) {
      // if (!this.sizeCalcState) {
      // 	this.calcSize();
      // }
      // const { scrollTop } = detail;
      // let tabs = this.goods.filter(item => item.top < scrollTop).reverse();
      // console.log(tabs)
      // if (tabs.length > 0) {
      // 	this.currentCategoryName = tabs[0].goodsCategoryName;
      // }
      var detail = _ref.detail;},

    // 辅助函数，滚动时判断事件用
    calcSize: function calcSize() {
      var that = this;
      // 这里是真的坑!!! 微信里没法绑定获取，暂时只能这样了
      var view = uni.createSelectorQuery().selectAll('#categoryMenu');
      view.fields(
      {
        size: true // 返回高和宽
      },
      function (data) {
        // eg: {width: 219, height: 760}
      }).
      exec(function (res) {
        // 回调信息
        var h = 10;
        var whArr = res[0];
        console.log('右边菜单商品的高宽为: ', JSON.stringify(whArr));
        var goodsMenus = that.goods;
        for (var i = 0; i < that.goods.length; i++) {
          goodsMenus[i].top = h;
          h += whArr[i].height;
          goodsMenus[i].bottom = h;
        }
        that.sizeCalcState = true;
      });

    },
    // 获取商品具体价格，如大杯商品，小杯商品价格不同
    getGoodsRealPrice: function getGoodsRealPrice(goods) {
      console.log(goods);
      var realPrice = goods.realPrice;
      if (goods.goodsPropertyVos && goods.goodsPropertyVos.length) {
        var vos = goods.goodsPropertyVos;
        for (var i = 0; i < vos.length; i++) {
          var propertyList = vos[i].propertyList;
          for (var j = 0; j < propertyList.length; j++) {
            if (propertyList[j].isDefault && propertyList[j].realPrice) {
              realPrice = propertyList[j].realPrice;
              break;
            }
          }
        }
      }
      return realPrice;
    },
    // 显示当前商品的详情信息
    showGoodDetailModal: function showGoodDetailModal(currentGoods) {
      currentGoods.number = 1;
      currentGoods.realPrice = this.getGoodsRealPrice(currentGoods);
      currentGoods.propertyStr = this.getGoodSelectedProps(currentGoods);
      this.currentGoods = JSON.parse(JSON.stringify(currentGoods)); // 深拷贝

      this.goodDetailModalVisible = true;
      this.selectedPropertyList = [];
      console.log('显示当前商品的详情信息', this.currentGoods);
    },
    closeGoodDetailModal: function closeGoodDetailModal() {
      // 关闭饮品详情模态框
      this.goodDetailModalVisible = false;
    },
    // 改变商品的某个默认属性值 要区分必选和多选的属性
    changePropertyDefault: function changePropertyDefault(categoryIndex, propertyIndex) {
      var propertyCategory = this.currentGoods.goodsPropertyVos[categoryIndex].category;
      var propertyList = this.currentGoods.goodsPropertyVos[categoryIndex].propertyList;
      if (propertyCategory != '加料') {
        // 必须选一个
        propertyList.forEach(function (property) {return property.isDefault = false;}); // 重置所有默认选择状态重新选择
        propertyList[propertyIndex].isDefault = true;
        if (propertyCategory == '大小') {
          this.currentGoods.realPrice = this.currentGoods.realPrice - this.currentGoods.defaultPrice + propertyList[propertyIndex].rebasePrice;
          this.currentGoods.defaultPrice = propertyList[propertyIndex].rebasePrice;
          this.currentGoods.number = 1;
          this.currentGoods.propertyStr = this.getGoodSelectedProps(this.currentGoods);
        }
      } else {
        // 可选项  加料或减料
        if (propertyList[propertyIndex].isDefault) {
          this.currentGoods.realPrice -= propertyList[propertyIndex].extraPrice;
          propertyList[propertyIndex].isDefault = false;
        } else {
          this.currentGoods.realPrice += propertyList[propertyIndex].extraPrice;
          propertyList[propertyIndex].isDefault = true;
        }
      }
    },
    // 计算当前饮品所选属性，空格隔开
    getGoodSelectedProps: function getGoodSelectedProps(goods) {
      if (goods.goodsPropertyVos) {
        var propertyStr = '';
        goods.goodsPropertyVos.forEach(function (goodsPropertyVo) {
          goodsPropertyVo.propertyList.forEach(function (property) {
            if (property.isDefault) {
              propertyStr += property.propertyOption + ' ';
            }
          });
        });
        return propertyStr;
      }
      return '';
    },
    // 改变当前商品数量
    changeCurrentGoodsNumber: function changeCurrentGoodsNumber(number) {
      this.currentGoods.number += number;
      if (this.currentGoods.number < 0) {
        this.currentGoods.number = 0;
      } else if (this.currentGoods.number >= 100) {
        this.currentGoods.number = 100;
      }
    },
    // 将当前商品加入到购物车
    addCurrentGoodsToCart: function addCurrentGoodsToCart() {
      if (this.currentGoods && this.currentGoods.number) {
        this.handleAddToCart(this.currentGoods);
      }
      this.closeGoodDetailModal();
    },
    // 减少购物车里的商品数量, goodsId和propertyStr去比较
    handleReduceFromCart: function handleReduceFromCart(goods) {
      var propertyStr = this.getGoodSelectedProps(goods);
      var cart = this.cart;
      for (var i = cart.length - 1; i >= 0; i--) {
        if (cart[i].id == goods.id && cart[i].propertyStr == propertyStr) {
          if (cart[i].number <= 1) cart.splice(i, 1);else
          cart[i].number -= 1;
          return;
        }
      }
    },
    // 添加到购物车
    handleAddToCart: function handleAddToCart(goods) {
      var propertyStr = this.getGoodSelectedProps(goods);
      goods.propertyStr = propertyStr;
      var cart = this.cart;
      for (var i = cart.length - 1; i >= 0; i--) {
        if (cart[i].id == goods.id && cart[i].propertyStr == propertyStr) {
          cart[i].number++;
          return;
        }
      }

      // 购物车里不存在
      if (!goods.number) goods.number = 1;
      this.cart.push(JSON.parse(JSON.stringify(goods)));
    },
    // 清空购物车
    handleCartClear: function handleCartClear() {
      var that = this;
      uni.showModal({
        title: '提示',
        content: '确定清空购物车么',
        success: function success(_ref2) {var confirm = _ref2.confirm;
          if (confirm) {
            that.cartPopupVisible = false;
            that.$store.commit('set_cart', []);
          }
        } });

    },
    // 在购物车里操作商品数量
    handleCartItemAdd: function handleCartItemAdd(index) {
      this.cart[index].number += 1;
    },
    handleCartItemReduce: function handleCartItemReduce(index) {
      if (this.cart[index].number === 1) {
        this.cart.splice(index, 1);
      } else {
        this.cart[index].number -= 1;
      }
      if (!this.cart.length) {
        this.cartPopupVisible = false;
      }
    },
    toPay: function toPay() {
      this.cartPopupVisible = false;
      if (!this.userInfo) {
        uni.navigateTo({ url: '/pages/login/login' });
      }
      if (!this.userInfo.address || this.userInfo.address == '' || !this.userInfo.phone || this.userInfo.phone == '') {
        uni.showModal({
          content: '请先去设置收货信息',
          confirmText: '去设置',
          success: function success(e) {
            if (e.confirm) {
              uni.navigateTo({ url: '/pages/mine/userinfo' });
            }
          } });

        return;
      }

      console.log('进入支付页面');
      if (!this.userInfo) {
        uni.navigateTo({ url: '/pages/login/login' });
        return;
      }

      uni.navigateTo({
        url: '/pages/pay/pay' });

    } } };exports.default = _default;
/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./node_modules/@dcloudio/uni-mp-weixin/dist/index.js */ 1)["default"]))

/***/ }),

/***/ 33:
/*!******************************************************************************************************************************************!*\
  !*** /Users/panxianwen/Code/wx-applet/wx-naicha/naicha-ui/pages/menu/menu.vue?vue&type=style&index=0&id=368aef34&lang=scss&scoped=true& ***!
  \******************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_8_oneOf_1_0_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_dist_cjs_js_ref_8_oneOf_1_1_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_stylePostLoader_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_2_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_8_oneOf_1_3_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_sass_loader_dist_cjs_js_ref_8_oneOf_1_4_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_5_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_style_index_0_id_368aef34_lang_scss_scoped_true___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/mini-css-extract-plugin/dist/loader.js??ref--8-oneOf-1-0!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/css-loader/dist/cjs.js??ref--8-oneOf-1-1!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib/loaders/stylePostLoader.js!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--8-oneOf-1-2!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/postcss-loader/src??ref--8-oneOf-1-3!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-uni/packages/sass-loader/dist/cjs.js??ref--8-oneOf-1-4!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--8-oneOf-1-5!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib??vue-loader-options!../../../../../../../../Applications/HBuilderX.app/Contents/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/webpack-uni-mp-loader/lib/style.js!./menu.vue?vue&type=style&index=0&id=368aef34&lang=scss&scoped=true& */ 34);
/* harmony import */ var _Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_8_oneOf_1_0_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_dist_cjs_js_ref_8_oneOf_1_1_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_stylePostLoader_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_2_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_8_oneOf_1_3_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_sass_loader_dist_cjs_js_ref_8_oneOf_1_4_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_5_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_style_index_0_id_368aef34_lang_scss_scoped_true___WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_8_oneOf_1_0_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_dist_cjs_js_ref_8_oneOf_1_1_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_stylePostLoader_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_2_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_8_oneOf_1_3_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_sass_loader_dist_cjs_js_ref_8_oneOf_1_4_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_5_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_style_index_0_id_368aef34_lang_scss_scoped_true___WEBPACK_IMPORTED_MODULE_0__);
/* harmony reexport (unknown) */ for(var __WEBPACK_IMPORT_KEY__ in _Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_8_oneOf_1_0_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_dist_cjs_js_ref_8_oneOf_1_1_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_stylePostLoader_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_2_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_8_oneOf_1_3_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_sass_loader_dist_cjs_js_ref_8_oneOf_1_4_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_5_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_style_index_0_id_368aef34_lang_scss_scoped_true___WEBPACK_IMPORTED_MODULE_0__) if(__WEBPACK_IMPORT_KEY__ !== 'default') (function(key) { __webpack_require__.d(__webpack_exports__, key, function() { return _Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_8_oneOf_1_0_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_dist_cjs_js_ref_8_oneOf_1_1_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_stylePostLoader_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_2_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_8_oneOf_1_3_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_sass_loader_dist_cjs_js_ref_8_oneOf_1_4_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_5_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_style_index_0_id_368aef34_lang_scss_scoped_true___WEBPACK_IMPORTED_MODULE_0__[key]; }) }(__WEBPACK_IMPORT_KEY__));
 /* harmony default export */ __webpack_exports__["default"] = (_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_8_oneOf_1_0_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_dist_cjs_js_ref_8_oneOf_1_1_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_stylePostLoader_js_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_2_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_8_oneOf_1_3_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_sass_loader_dist_cjs_js_ref_8_oneOf_1_4_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_5_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_Applications_HBuilderX_app_Contents_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_menu_vue_vue_type_style_index_0_id_368aef34_lang_scss_scoped_true___WEBPACK_IMPORTED_MODULE_0___default.a); 

/***/ }),

/***/ 34:
/*!**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/mini-css-extract-plugin/dist/loader.js??ref--8-oneOf-1-0!./node_modules/css-loader/dist/cjs.js??ref--8-oneOf-1-1!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib/loaders/stylePostLoader.js!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--8-oneOf-1-2!./node_modules/postcss-loader/src??ref--8-oneOf-1-3!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/sass-loader/dist/cjs.js??ref--8-oneOf-1-4!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--8-oneOf-1-5!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib??vue-loader-options!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/style.js!/Users/panxianwen/Code/wx-applet/wx-naicha/naicha-ui/pages/menu/menu.vue?vue&type=style&index=0&id=368aef34&lang=scss&scoped=true& ***!
  \**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// extracted by mini-css-extract-plugin
    if(false) { var cssReload; }
  

/***/ })

},[[24,"common/runtime","common/vendor"]]]);
//# sourceMappingURL=../../../.sourcemap/mp-weixin/pages/menu/menu.js.map