<template>
  <div id="globalFooter">
    <div class="footer-left">
      <div class="QRCode">
        <h3 style="color: #181818 ; margin-bottom: 0 ; text-align: center">联系作者:</h3>
        <img src="@/assets/QRCode.png" alt="二维码">
      </div>
    </div>

    <div class="footer-right">
      <!-- 上部分：原来的内容 -->
      <div class="footer-content">
        <h3 style="color: #181818; margin-bottom: 16px;">关于我们</h3>
        <p style="color: #666; line-height: 1.6; margin: 0;">
          这是一个学习管理系统，致力于为学生和教师提供更好的学习体验。
        </p>
        <div class="contact-info" style="margin-top: 16px;">
          <p style="color: #666; margin: 4px 0;">邮箱: contact@vstudy.com</p>
          <p style="color: #666; margin: 4px 0;">电话: 400-123-4567</p>
        </div>
      </div>

      <!-- 分割线 -->
      <div class="divider"></div>
      <!-- 下部分：版权信息 -->
      <div class="footer-copyright">
        <p style="color: #999; font-size: 12px; margin: 0; text-align: center;">
          © 2025 VStudy 学习管理系统. 保留所有权利.
        </p>
        <p style="color: #999; font-size: 12px; margin: 4px 0 0 0; text-align: center;">
          ICP备案号: 京ICP备12345678号 | 技术支持: vv
        </p>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import {useRoute} from 'vue-router';

const route = useRoute();
</script>

<style scoped>
/* 使用 :deep() 来覆盖父容器的样式 */
:deep(.arco-layout-footer) {
  height: auto !important;
  background-color: transparent !important;
  padding: 0 !important;
  display: block !important;
}

#globalFooter {
  display: flex;
  align-items: flex-start;
  padding: 24px;
  justify-content: space-between;
  background-color: #f8f9fa;
  border-top: 1px solid #e9ecef;
  width: 100%;
  min-height: 200px;
}

.footer-left {
  flex: 0 0 auto;
}

.footer-right {
  flex: 1;
  margin-left: 48px;
  display: flex;
  flex-direction: column;
}

.footer-content {
  max-width: 400px;
}

/* 右侧区域内的分割线 */
.divider {
  height: 1px;
  width: 100%;
  background-color: #e0e0e0;
  margin: 16px 0;
}

/* 版权信息区域 */
.footer-copyright {
  margin-top: 8px;
}

.QRCode {
  width: 160px;
  height: 160px;
}

.QRCode img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  display: block; /* 消除图片底部空隙 */
}

/* 响应式设计 */
@media (max-width: 768px) {
  #globalFooter {
    flex-direction: column;
    align-items: center;
    text-align: center;
  }

  .footer-right {
    margin-left: 0;
    margin-top: 24px;
  }

  .footer-content {
    max-width: 100%;
  }
}
</style>
