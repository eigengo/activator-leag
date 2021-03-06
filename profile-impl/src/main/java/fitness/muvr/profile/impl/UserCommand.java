package fitness.muvr.profile.impl;

import akka.NotUsed;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import com.lightbend.lagom.javadsl.persistence.PersistentEntity;
import com.lightbend.lagom.serialization.CompressedJsonable;
import com.lightbend.lagom.serialization.Jsonable;
import fitness.muvr.profile.api.UserService;

import javax.annotation.concurrent.Immutable;

/**
 * A common type for all commands that the user entity can handle
 */
public interface UserCommand extends Jsonable {

    /**
     * Get public profile
     */
    @Immutable
    @JsonDeserialize
    final class GetPublicProfile implements UserCommand, CompressedJsonable, PersistentEntity.ReplyType<UserService.PublicProfile> {

    }

    /**
     * Set public profile
     */
    @Immutable
    @JsonDeserialize
    final class SetPublicProfile implements UserCommand, CompressedJsonable, PersistentEntity.ReplyType<NotUsed> {
        final UserService.PublicProfile publicProfile;

        @JsonCreator
        public SetPublicProfile(UserService.PublicProfile publicProfile) {
            this.publicProfile = publicProfile;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SetPublicProfile that = (SetPublicProfile) o;
            return Objects.equal(publicProfile, that.publicProfile);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(publicProfile);
        }
    }

    /**
     * Login
     */
    @Immutable
    @JsonDeserialize
    final class Login implements UserCommand, CompressedJsonable, PersistentEntity.ReplyType<String> {
        final String password;

        @JsonCreator
        public Login(String password) {
            this.password = password;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Login login = (Login) o;
            return Objects.equal(password, login.password);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(password);
        }
    }

    /**
     * Register
     */
    @Immutable
    @JsonDeserialize
    final class Register implements UserCommand, CompressedJsonable, PersistentEntity.ReplyType<NotUsed>  {
        final String password;

        @JsonCreator
        public Register(String password) {
            this.password = password;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Register that = (Register) o;
            return Objects.equal(password, that.password);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(password);
        }
    }

}
