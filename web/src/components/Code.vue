<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="18" :offset="3">
        <el-form :inline="true" :model="item" :rules="rules" ref="form">
          <el-form-item label="描述" prop="name">
            <el-input v-model="item.name" placeholder="描述"></el-input>
          </el-form-item>
          <el-form-item label="路径" prop="path">
            <el-input v-model="item.path" placeholder="路径"></el-input>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="18" :offset="3">
        <codemirror ref="editor" v-model="item.code" :options="options"></codemirror>
      </el-col>
    </el-row>
    <el-row :gutter="20" style="margin-top: 10px;">
      <el-col :span="18" :offset="3">
        <el-button type="primary" @click="save">保存</el-button>
        <el-button type="info" @click="format">格式化代码</el-button>
        <el-button type="success" @click="fullScreen">全屏</el-button>
      </el-col>

    </el-row>
  </div>
</template>

<script>
  export default {
    name: "Code",
    data() {
      return {
        item:{
          name:"",
          path:'',
          code:''
        },
        options:{
          height: "500px",
          tabSize: 4,
          mode: 'text/javascript',
          theme: 'monokai',
          lineNumbers: true,
          line: true,
          lineWrapping: true,	//代码折叠
          foldGutter: true,
          gutters: ["CodeMirror-linenumbers", "CodeMirror-foldgutter"],
          matchBrackets: true,
          autoCloseBrackets:true,
          smartIndent: true,
          extraKeys:{
            "Esc": function(cm) {
              if (cm.getOption("fullScreen")) cm.setOption("fullScreen", false);
            }
          }
        },
        rules:{
          name:[{ required: true, message: '请输入', trigger: 'blur' }],
          path:[{ required: true, message: '请输入', trigger: 'blur' }],
        }
      }
    },
    methods:{
      format(){

        var editor = this.$refs.editor.codemirror;
        var code = editor.getValue();
        editor.setValue(JSON.stringify(JSON.parse(code), null, 2))
      },
      fullScreen(){
        var editor = this.$refs.editor.codemirror;
        editor.setOption('fullScreen',true)
      },
      save(){
        var editor = this.$refs.editor.codemirror;
        this.item.code = JSON.stringify(JSON.parse(editor.getValue()));
        this.$axios.post('/mock/save',this.item).then((res)=>{
            console.log(res);
        })
      }
    },
    mounted(){
      if(this.$route.params.item){
        this.item = this.$route.params.item;
      }
      this.$refs.editor.codemirror.setSize('auto','600px')

    }
  }
</script>

<style scoped>

</style>
