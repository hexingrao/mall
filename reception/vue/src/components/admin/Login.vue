<template>
  <div>
    <!--<video id="v1" autoplay loop muted>-->
    <!--<source src="../../assets/pai.mp4">-->
    <!--</video>-->

    <div class="login-register">
      <div class="contain">
        <div class="big-box" :class="{active:isLogin}">
          <div class="big-contain" key="bigContainLogin" v-if="isLogin">
            <div class="btitle">创建账户</div>
            <el-form :model="admin" :rules="rules" ref="ruleForm" style="width: 300px; height: 300px">

              <el-form-item prop="username">
                <el-input size="medium" clearable style="margin-top: 30px;" prefix-icon="el-icon-user" v-model="admin.username"
                          placeholder="请输入账户"></el-input>
              </el-form-item>

              <el-form-item prop="nickname">
                <el-input size="medium" clearable style="margin-top: 30px;" prefix-icon="el-icon-s-custom"
                          v-model="admin.nickname"
                          placeholder="请输入昵称"></el-input>
              </el-form-item>

              <el-form-item prop="password">
                <el-input size="medium" clearable auto-complete="new-password" style="margin-top: 30px;"
                          prefix-icon="el-icon-lock"
                          show-password v-model="admin.password" placeholder="请输入密码"></el-input>
              </el-form-item>

              <el-form-item prop="password">
                <el-input size="medium" clearable style="margin-top: 30px;" prefix-icon="el-icon-lock" show-password
                          v-model="admin.confirmPassword" placeholder="请确认密码"></el-input>
              </el-form-item>

              <div>
                <el-button class="loginButton" @click="register">注册</el-button>
                <el-button class="loginButton" style="float: right" @click="resetRegisterForm">重置</el-button>
              </div>

            </el-form>

          </div>
          <div class="big-contain" key="bigContainRegister" v-else>
            <div class="btitle">用户登录</div>

            <el-form :model="user" :rules="rules" ref="ruleForm" style="width: 300px; height: 250px">

              <el-form-item prop="username">
                <el-input size="medium" clearable style="margin-top: 30px;" prefix-icon="el-icon-user" v-model="user.username"
                          placeholder="请输入用户名"></el-input>
              </el-form-item>

              <el-form-item prop="password">
                <el-input size="medium" clearable auto-complete="new-password" style="margin-top: 30px;"
                          prefix-icon="el-icon-lock"
                          show-password v-model="user.password" placeholder="请输入密码"></el-input>
              </el-form-item>

              <div>
                <el-button class="loginButton" @click="login">登录</el-button>
                <el-button class="loginButton" style="float: right" @click="resetLoginForm">重置</el-button>
              </div>

            </el-form>
          </div>
        </div>
        <div class="small-box" :class="{active: isLogin}">

          <div class="small-contain" key="smallContainLogin" v-if="isLogin">
            <div class="stitle">欢迎回来</div>
            <p class="scontent">与我们保持联系，请开始登录您的账户</p>
            <button class="sbutton" @click="changeType">登录</button>
          </div>

          <div class="small-contain" key="smallContainRegister" v-else>
            <div class="stitle">你好，朋友</div>
            <p class="scontent">开始注册，和我们一起旅行</p>
            <button class="sbutton" @click="changeType">注册</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'Login',
    data () {
      const validateUsername = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入用户名'))
        } else {
          callback()
        }
      }

      const validatePassword = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'))
        } else if (value.length < 3) {
          callback(new Error('密码长度不能小于3'))
        } else {
          callback()
        }
      }

      const validateNickname = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入昵称'))
        } else {
          callback()
        }
      }

      return {
        user: {
          username: '',
          password: ''
        },
        admin: {
          username: '',
          nickname: '',
          password: '',
          confirmPassword: ''
        },
        isLogin: false,
        emailError: false,
        passwordError: false,
        existed: false,
        rules: {
          username: [
            {required: true, validator: validateUsername, trigger: 'blur'}
          ],
          password: [
            {required: true, validator: validatePassword, trigger: 'blur'}
          ],
          nickname: [
            {required: true, validator: validateNickname, trigger: 'blur'}
          ]
        },
      }
    },
    methods: {
      changeType () {
        this.isLogin = !this.isLogin
        // this.form.username = ''
        // this.form.useremail = ''
        // this.form.pwd = ''
      },
      login () {

        if (this.user.username === '' && this.user.password === '') {
          this.$notify.error('请输入账号和密码')
        } else if (this.user.username === '' && this.user.password !== '') {
          this.$notify.error('请输入账号')
        } else if (this.user.username !== '' && this.user.password === '') {
          this.$notify.error('请输入密码')
        } else {
          this.axios({
            method: 'post',
            url: 'http://localhost:9000/user/login',
            data: {
              username: this.user.username,
              password: this.user.password
            }
          }).then(res => {
            if (res.data.code === 200) {
              this.$router.push('/')
              this.$notify.success("登录成功")
            }
          })
        }
      },
      register () {
        if (this.admin.password !== this.admin.confirmPassword) {
          this.$notify.error('您输入的两次密码不一致')
        } else {
          this.axios({
            method: 'post',
            url: 'http://localhost:9000/user/register',
            data: {
              username: this.admin.username,
              nickname: this.admin.nickname,
              password: this.admin.password,
              confirmPassword: this.admin.confirmPassword
            }
          }).then(res => {
            if (res.data.code === 200) {
              this.$notify.success("注册成功")
              Object.assign(this.$data.admin, this.$options.data().admin)
            }
          })
        }
      },
      resetLoginForm () {
        Object.assign(this.$data.user, this.$options.data().user)
      },
      resetRegisterForm(){
        Object.assign(this.$data.admin, this.$options.data().admin)
      }
    }
  }
</script>

<style scoped="scoped">
  .login-register {
    width: 99vw;
    height: 95vh;
    box-sizing: border-box;
    background-image: url("../../assets/background.jpg");
  }

  .contain {
    width: 650px;
    height: 450px;
    position: relative;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    border-radius: 20px;
    box-shadow: 0 0 3px #f0f0f0, 0 0 6px #f0f0f0;
  }

  .big-box {
    width: 70%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 30%;
    transform: translateX(0%);
    transition: all 1s;
  }

  .big-contain {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }

  .btitle {
    font-size: 1.5em;
    font-weight: bold;
    color: rgb(57, 167, 176);
  }

  .bform .errorTips {
    display: block;
    width: 50%;
    text-align: left;
    color: red;
    font-size: 0.7em;
    margin-left: 1em;
  }

  .bform input {
    width: 50%;
    height: 30px;
    border: none;
    outline: none;
    border-radius: 10px;
    padding-left: 2em;
    background-color: #f0f0f0;
  }

  .small-box {
    width: 30%;
    height: 100%;
    background: linear-gradient(135deg, rgb(57, 167, 176), rgb(56, 183, 145));
    position: absolute;
    top: 0;
    left: 0;
    transform: translateX(0%);
    transition: all 1s;
    border-top-left-radius: inherit;
    border-bottom-left-radius: inherit;
  }

  .small-contain {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }

  .stitle {
    font-size: 1.5em;
    font-weight: bold;
    color: #fff;
  }

  .scontent {
    font-size: 0.5em;
    color: #fff;
    text-align: center;
    padding: 2em 2em;
    line-height: 1.7em;
  }

  .sbutton {
    width: 60%;
    height: 40px;
    border-radius: 24px;
    border: 1px solid #fff;
    outline: none;
    background-color: transparent;
    color: #fff;
    font-size: 0.9em;
    cursor: pointer;
  }

  .big-box.active {
    left: 0;
    transition: all 0.5s;
  }

  .small-box.active {
    left: 100%;
    border-top-left-radius: 0;
    border-bottom-left-radius: 0;
    border-top-right-radius: inherit;
    border-bottom-right-radius: inherit;
    transform: translateX(-100%);
    transition: all 1s;
  }

  * {
    margin: 0px;
    padding: 0px;
  }

  video {
    position: fixed;
    right: 0;
    bottom: 0;
    min-width: 100%;
    min-height: 100%;
    height: auto;
    width: auto;
    z-index: -1000;
  }

  source {
    min-width: 100%;
    min-height: 100%;
    height: auto;
    width: auto;
  }

  .loginButton {
    width: 80px;
    height: 40px;
    margin: 30px auto;
    border-radius: 24px;
    border: none;
    outline: none;
    background-color: rgb(57, 167, 176);
    color: #fff;
    font-size: 0.9em;
    cursor: pointer;
  }

  .loginButton:hover {
    box-shadow: 0 0 10px 10px #00000020;
  }
</style>
