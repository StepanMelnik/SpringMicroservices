package com.sme.springcloud.common.util;

import java.util.Objects;

import com.sme.springcloud.common.model.UserContext;

/**
 * User context holder.
 */
public class UserContextHolder
{
    private static final ThreadLocal<UserContext> USER_CONTEXT = new ThreadLocal<>();

    /**
     * Fetch {@link UserContext} connected to thread local.
     * 
     * @return Returns {@link UserContext} context.
     */
    public static final UserContext getContext()
    {
        UserContext context = USER_CONTEXT.get();

        if (context == null)
        {
            context = new UserContext();
            USER_CONTEXT.set(context);

        }
        return USER_CONTEXT.get();
    }

    /**
     * Set {@link UserContext}.
     * 
     * @param context The user context.
     */
    public static final void setContext(UserContext context)
    {
        Objects.requireNonNull(context, "Requires not null context");
        USER_CONTEXT.set(context);
    }

    /**
     * Clean up thread local of user context.
     */
    public static final void remove()
    {
        USER_CONTEXT.remove();
    }
}
