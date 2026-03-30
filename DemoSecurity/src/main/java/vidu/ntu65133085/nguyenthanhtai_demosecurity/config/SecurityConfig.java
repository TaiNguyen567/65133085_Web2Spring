package vidu.ntu65133085.nguyenthanhtai_demosecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
				// 1. Cấp quyền VIP (Ai cũng được vào trang chủ "/" và thư mục "/public")
				.requestMatchers("/", "/public/**").permitAll()

				// 2. Phân quyền chặt chẽ
				.requestMatchers("/products/**").hasRole("USER").requestMatchers("/admin/**").hasRole("ADMIN")

				// 3. Các trang khác (nếu có) thì bắt buộc phải đăng nhập
				.anyRequest().authenticated()).formLogin(form -> form
						// ĐÓNG TẠM dòng này để dùng form Login mặc định của Spring
						// .loginPage("/login")
						.permitAll()
						// Đăng nhập thành công thì đá về trang chủ
						.defaultSuccessUrl("/", true))
				.logout(logout -> logout.permitAll()
						// Đăng xuất xong thì quay về trang chủ
						.logoutSuccessUrl("/"));
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		// Tạo sẵn 2 tài khoản trong bộ nhớ ảo (RAM) để test
		UserDetails user = User.withUsername("user").password("{noop}123").roles("USER").build();

		UserDetails admin = User.withUsername("admin").password("{noop}123456").roles("ADMIN", "USER") // Admin có cả 2
																										// quyền
				.build();

		return new InMemoryUserDetailsManager(user, admin);
	}
}